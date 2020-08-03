package org.homeprog.customerrequestsstat.controller;

import org.homeprog.customerrequestsstat.DTO.CustomerDTO;
import org.homeprog.customerrequestsstat.entity.Customer;
import org.homeprog.customerrequestsstat.service.StatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
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
    }

    //Date parameters shall be passed as "yyyy-MM-dd HH:mm:ss"
    @GetMapping("/api/stats/{customer_id}/from/{date_from}/to/{date_to}")
    public List<CustomerDTO> getCustomersByCustomerIdAndTimePeriod(@PathVariable("customer_id") long id,
                                                                   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
                                                                   @PathVariable("date_from") LocalDateTime fromDate,
                                                                   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
                                                                   @PathVariable("date_to") LocalDateTime toDate) {
        List<Customer> statCustomers = service
                           .getCustomersByCustomerIdAndTimeBetweenTwoDates(id, fromDate, toDate);

        return  statCustomers.stream().map(customer -> modelMapper
                .map(customer, CustomerDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/api/stats/{customer_id}/statuses/{request_status}")
    public List<CustomerDTO> getCustomersByCustomerIdAndRequestStatus(@PathVariable("customer_id") long id,
                                                                      @PathVariable("request_status") boolean isValid) {
        List<Customer> statCustomers = service.getCustomersByCustomerIdAndRequestStatus(id, isValid);

        return  statCustomers.stream().map(customer -> modelMapper
                .map(customer, CustomerDTO.class)).collect(Collectors.toList());
    }

    //Date parameters shall be passed as "yyyy-MM-dd HH:mm:ss"
    @GetMapping("/api/stats/{customer_id}/statuses/{request_status}/from/{date_from}/to/{date_to}")
    public List<CustomerDTO> getCustomersByCustomerIdAndRequestStatusAndTimePeriod
                                 (@PathVariable("customer_id") long id,
                                  @PathVariable("request_status") boolean isValid,
                                  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
                                  @PathVariable("date_from") LocalDateTime fromDate,
                                  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
                                  @PathVariable("date_to") LocalDateTime toDate) {

        List<Customer> statCustomers = service
                          .getCustomersByCustomerIdAndRequestStatusAndTimeBetweenTwoDates(id, isValid, fromDate, toDate);

        return  statCustomers.stream().map(customer -> modelMapper
                .map(customer, CustomerDTO.class)).collect(Collectors.toList());
    }
}
