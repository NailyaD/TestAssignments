package org.homeprog.customerrequestsstat.controller;

import org.homeprog.customerrequestsstat.DTO.StatCustomerDTO;
import org.homeprog.customerrequestsstat.entity.StatCustomer;
import org.homeprog.customerrequestsstat.service.StatService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class StatController {

    private final StatService service;
    private final ModelMapper modelMapper;

    public StatController(StatService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(statCustomerMapping);
        this.modelMapper.addMappings(statCustomerIdMapping);
    }

    @PostMapping("/api/customers")
    public StatCustomer addStatCustomer(@RequestBody StatCustomerDTO statCustomerDTO) {
        StatCustomer statCustomer = modelMapper.map(statCustomerDTO, StatCustomer.class);
        Date dateAndTime = new Date();
        statCustomer.setTime(dateAndTime);
        statCustomer.setValid(true);
        return service.addStatCustomer(statCustomer);
    }

    /*TODO
    @GetMapping("/api/stats?customer_id={id}&time={date}")
    public List<StatCustomer> getCustomerStatisticsByDate(@PathVariable long id, @PathVariable Date date) {
        return service.getCustomerStatisticsByDate(id, date);
    }*/

    /*@GetMapping("/api/stats?customer_id={id}&validation_status={validation_status}")
    public List<StatCustomer> getCustomerStatisticsByValidationStatus() {
        return service.getCustomerStatisticsByValidationStatus();
        &date={date}
    }*/

    /*@GetMapping("/api/stats?customer_id={id}&date={date}&validation_status={validation_status}")
    public List<StatCustomer> getCustomerStatisticsByDateAndValidationStatus() {
        return service.getCustomerStatisticsByDateAndValidationStatus();
    }*/

    PropertyMap<StatCustomerDTO, StatCustomer> statCustomerMapping = new PropertyMap<StatCustomerDTO, StatCustomer>() {
        protected void configure() {
            map().getCustomer().setId(source.getCustomerId());
        }
    };

    PropertyMap<StatCustomer, StatCustomerDTO> statCustomerIdMapping = new PropertyMap<StatCustomer, StatCustomerDTO>() {
        protected void configure() {
            map().setCustomerId(source.getCustomer().getId());
        }
    };
}
