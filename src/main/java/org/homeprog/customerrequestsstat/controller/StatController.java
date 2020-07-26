package org.homeprog.customerrequestsstat.controller;

import org.homeprog.customerrequestsstat.DTO.StatCustomerDTO;
import org.homeprog.customerrequestsstat.entity.StatCustomer;
import org.homeprog.customerrequestsstat.service.StatService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StatController {

    private final StatService service;
    private final ModelMapper modelMapper;

    @Autowired
    public StatController(StatService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(statCustomerMapping);
        this.modelMapper.addMappings(statCustomerIdMapping);
    }

    @PostMapping("/api/customers")
    public StatCustomer addStatCustomer(@RequestBody StatCustomerDTO statCustomerDTO) {
        StatCustomer statCustomer = modelMapper.map(statCustomerDTO, StatCustomer.class);
        statCustomer.setValid(false);
        return service.addStatCustomer(statCustomer);
    }

    //Date parameters shall be passed as "yyyy-MM-dd HH:mm:ss"
    @GetMapping("/api/stats/{customer_id}/from/{date_from}/to/{date_to}")
    public List<StatCustomerDTO> getCustomersByCustomerIdAndTimePeriod(@PathVariable("customer_id") long id,
                                                                 @PathVariable("date_from")
                                                                 String fromDate,
                                                                 @PathVariable("date_to")
                                                                 String toDate) {
        Instant instantFrom = stringToInstantConverter(fromDate);
        Instant instantTo = stringToInstantConverter(toDate);

        List<StatCustomer> statCustomers = service
                           .getStatCustomersByCustomerIdAndTimeBetweenTwoDates(id, instantFrom, instantTo);

        return  statCustomers.stream().map(customer -> modelMapper
                .map(customer, StatCustomerDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/api/stats/{customer_id}/statuses/{request_status}")
    public List<StatCustomerDTO> getCustomersByCustomerIdAndRequestStatus(@PathVariable("customer_id") long id,
                                                                          @PathVariable("request_status") boolean isValid) {
        List<StatCustomer> statCustomers = service.getStatCustomersByCustomerIdAndRequestStatus(id, isValid);

        return  statCustomers.stream().map(customer -> modelMapper
                .map(customer, StatCustomerDTO.class)).collect(Collectors.toList());
    }

    //Date parameters shall be passed as "yyyy-MM-dd HH:mm:ss"
    @GetMapping("/api/stats/{customer_id}/statuses/{request_status}/from/{date_from}/to/{date_to}")
    public List<StatCustomerDTO> getCustomersByCustomerIdAndRequestStatusAndTimePeriod
                                 (@PathVariable("customer_id") long id,
                                  @PathVariable("request_status") boolean isValid,
                                  @PathVariable("date_from") String fromDate,
                                  @PathVariable("date_to") String toDate) {

        Instant instantFrom = stringToInstantConverter(fromDate);
        Instant instantTo = stringToInstantConverter(toDate);

        List<StatCustomer> statCustomers = service
                          .getStatCustomersByCustomerIdAndRequestStatusAndTimeBetweenTwoDates(id, isValid, instantFrom, instantTo);

        return  statCustomers.stream().map(customer -> modelMapper
                .map(customer, StatCustomerDTO.class)).collect(Collectors.toList());
    }

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

    public Instant stringToInstantConverter(String string) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDate localDateFrom = LocalDate.parse(string, formatter);
        return localDateFrom.atStartOfDay(ZoneId.systemDefault()).toInstant();
    }
}
