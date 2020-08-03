package org.homeprog.customerrequestsstat.controller;

import org.homeprog.customerrequestsstat.DTO.CustomerDTO;
import org.homeprog.customerrequestsstat.entity.Customer;
import org.homeprog.customerrequestsstat.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CustomerController {
    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerController(CustomerService customerService, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(customerMapping);
        this.modelMapper.addMappings(customerIdMapping);
    }

    //A method for Post request to insert a valid or invalid entry into statistics database
    //If a request is valid (i.e. all JSON fields are not null or empty or
    //userID/remoteIp field values are not in corresponding blacklists) an entry is stored in DB with true value
    //If a request is invalid (one or more JSON field is null or empty) an entry is rejected and isn't stored in DB
    //If a request is invalid (userID/remoteIp field value is in corresponding blacklists) an entry is stored in DB with false value
    @PostMapping("/api/customers")
    public Customer addCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        Long customerId = customerDTO.getCustomerId();
        return customerService.addCustomer(customerId, customer);
    }

    PropertyMap<CustomerDTO, Customer> customerMapping = new PropertyMap<CustomerDTO, Customer>() {
        protected void configure() {
            map().getDbCustomer().setId(source.getCustomerId());
        }
    };

    PropertyMap<Customer, CustomerDTO> customerIdMapping = new PropertyMap<Customer, CustomerDTO>() {
        protected void configure() {
            map().setCustomerId(source.getDbCustomer().getId());
        }
    };
}
