package org.homeprog.customerrequestsstat.controller;

import org.homeprog.customerrequestsstat.DTO.StatCustomerDTO;
import org.homeprog.customerrequestsstat.entity.StatCustomer;
import org.homeprog.customerrequestsstat.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerController(CustomerService customerService, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(statCustomerMapping);
        this.modelMapper.addMappings(statCustomerIdMapping);
    }

    @PostMapping("/api/customers")
    public StatCustomer addStatCustomer(@RequestBody StatCustomerDTO statCustomerDTO) {
        StatCustomer statCustomer = modelMapper.map(statCustomerDTO, StatCustomer.class);
        Long customerId = statCustomerDTO.getCustomerId();
        return customerService.addStatCustomer(customerId, statCustomer);
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
}
