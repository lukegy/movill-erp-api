package net.movill.erp.service;

import lombok.extern.slf4j.Slf4j;
import net.movill.erp.dto.ErpResidentDto;
import net.movill.erp.entity.ErpEventEntity;
import net.movill.erp.entity.ErpOwnerEntity;
import net.movill.erp.entity.ErpResidentEntity;
import net.movill.erp.prop.ErpSiteProperties;
import net.movill.erp.repository.ErpEventRepository;
import net.movill.erp.repository.ErpOwnerRepository;
import net.movill.erp.repository.ErpResidentRepository;
import net.movill.erp.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("residentService")
public class ResidentService {

    @Autowired
    private ErpEventRepository erpEventRepository;

    @Autowired
    private ErpOwnerRepository erpOwnerRepository;

    @Autowired
    private ErpResidentRepository erpResidentRepository;

    @Autowired
    private ErpSiteProperties properties;


    /**
     * Async 하게 동작함
     *  타사 ERP 연동
     */
    public void syncResident(ErpEventEntity event) {
        String url = properties.getUrl(event);
        if (!StringUtils.isEmpty(url)) {
            Utility.sendPost(url, event, new ParameterizedTypeReference<List<ErpResidentDto>>() {})
                    .subscribe(response -> {
                        List<ErpResidentEntity> residentEntities = new ArrayList<>();
                        List<ErpOwnerEntity> ownerEntities = new ArrayList<>();

                        List<ErpResidentDto> residents = (List<ErpResidentDto>) response;
                        residents.forEach(r -> {
                            if (r.getIsHousehold()) {
                                ownerEntities.add(new ErpOwnerEntity(r, event.getAptIdx()));
                            }
                            residentEntities.add(new ErpResidentEntity(r, event.getAptIdx()));
                        });

                        // 세대주 (erp_owner), 입주민 (erp_resident) 데이터 삭제 //
                        deleteByEvent(event)
                                .subscribe(count -> {
                                    log.debug("deleted count: " + count);

                                    // 입주민 (erp_resident) 등록 //
                                    if (!residentEntities.isEmpty()) {
                                        saveResidentBulk(residentEntities).subscribe(s -> log.debug(""), error -> log.error("", error));
                                    }

                                    // 세대주 (erp_owner) 등록 //
                                    if (!ownerEntities.isEmpty()) {
                                        saveOwnerBulk(ownerEntities).subscribe(s -> log.debug(""), error -> log.error("", error));
                                    }
                                });

                        // 정상적으로 등록된 event 는 삭제 처리 //
                        erpEventRepository.deleteById(event.getIdx());
                    });
        }
    }

    public Mono<Integer> deleteByEvent(ErpEventEntity eventDto) {
        Mono<Integer> deleteOwner = Mono.fromCallable(() -> erpOwnerRepository.deleteByAptIdxAndDongAndHo(eventDto.getAptIdx(), eventDto.getDong(), eventDto.getHo()));
        Mono<Integer> deleteResident = Mono.fromCallable(() -> erpResidentRepository.deleteByAptIdxAndDongAndHo(eventDto.getAptIdx(), eventDto.getDong(), eventDto.getHo()));
        return Mono.zip(deleteOwner, deleteResident, (cntOwner, cntResident) -> cntOwner + cntResident);
    }

    public Mono<List<ErpOwnerEntity>> saveOwnerBulk(List<ErpOwnerEntity> entities) {
        return Mono.fromCallable(() -> erpOwnerRepository.saveAll(entities));
    }

    public Mono<List<ErpResidentEntity>> saveResidentBulk(List<ErpResidentEntity> entities) {
        return Mono.fromCallable(() -> erpResidentRepository.saveAll(entities));
    }

}
