package net.movill.erp.controller;

import lombok.extern.slf4j.Slf4j;
import net.movill.erp.dto.ErpResidentDto;
import net.movill.erp.dto.EventDto;
import net.movill.erp.service.BillService;
import net.movill.erp.service.CarService;
import net.movill.erp.service.ErpEventService;
import net.movill.erp.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/")
public class ApiRestController {

    @Autowired
    private ErpEventService erpEventService;

    @Autowired
    private ResidentService residentService;

    @Autowired
    private CarService carService;

    @Autowired
    private BillService billService;

    @Autowired
    private Scheduler scheduler;


    @PostMapping("/v1/event")
    @ResponseBody
    @Transactional
    public Mono<ResponseEntity<Object>> event(@RequestBody @Valid EventDto eventDto) {
        return erpEventService.saveResidentEvent(eventDto)
                .publishOn(scheduler)
                .doOnNext(savedEvent -> {
                    switch (savedEvent.getEvent()) {
                        case RESIDENT:
                            residentService.syncResident(savedEvent);
                            break;

                        case CAR:
                            carService.syncCar(savedEvent);
                            break;

                        case BILL:
                            billService.syncBill(savedEvent);
                            break;
                    }
                })
                .flatMap(savedEvent -> Mono.just(ResponseEntity.ok(true)));
    }

    @RequestMapping("/actuator/erpTest")
    @ResponseBody
    public Mono<ResponseEntity<List<ErpResidentDto>>> erpTest(
            @RequestParam(name = "siteIdx", required = false) Long siteIdx,
            @RequestParam("dong") String dong,
            @RequestParam("ho") String ho) {
        List<ErpResidentDto> list = new ArrayList<>();
        for (int i=0; i<5; i++) {
            list.add(new ErpResidentDto(dong, ho, "세대원", "0101234123" + i, i == 0, "20200101"));
        }
        return Mono.just(ResponseEntity.ok(list));
    }


}
