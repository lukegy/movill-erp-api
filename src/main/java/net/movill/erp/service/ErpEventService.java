package net.movill.erp.service;

import net.movill.common.exception.MovillException;
import net.movill.erp.dto.EventDto;
import net.movill.erp.entity.ErpEventEntity;
import net.movill.erp.enums.EventType;
import net.movill.erp.repository.ErpEventRepository;
import net.movill.erp.repository.ErpSiteMappingRepository;
import net.movill.erp.repository.MasterHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service("erpEventService")
public class ErpEventService {

    @Autowired
    private ErpSiteMappingRepository erpSiteMappingRepository;

    @Autowired
    private MasterHouseRepository masterHouseRepository;

    @Autowired
    private ErpEventRepository erpEventRepository;


    public Mono<ErpEventEntity> saveResidentEvent(EventDto eventDto) {
        return Mono.just(eventDto)
                .map(e -> {
                    // site_idx -> apt_idx 로 mapping //
                    try {
                        Long aptIdx = erpSiteMappingRepository.findBySiteIdxAndType(eventDto.getSiteIdx(), eventDto.getType()).getAptIdx();
                        e.setAptIdx(aptIdx);
                    } catch (Exception excption) {
                        throw new MovillException("400", "존재하지 않는 아파트");
                    }

                    // master 정보에 해당 동/호가 있는지 확인 //
                    if (e.getEvent() == EventType.RESIDENT) {
                        if (!masterHouseRepository.existsByAptIdxAndDongAndHo(e.getAptIdx(), e.getDong(), e.getHo())) {
                            throw new MovillException("400", "마스터 정보에 존재하지 않는 아파트");
                        }
                    }
                    return e;
                })

                // erp_event 에 저장 //
                .flatMap(e -> Mono.fromCallable(() -> erpEventRepository.save(new ErpEventEntity(e))));
    }

    public Mono<Boolean> exsistsEvent(EventDto dto) {
        return Mono.fromCallable(() -> erpEventRepository.existsBySiteIdxAndTypeAndDongAndHoAndEvent(dto.getSiteIdx(), dto.getType(), dto.getDong(), dto.getHo(), dto.getEvent()));
    }

}
