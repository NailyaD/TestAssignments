package org.homeprog.customerrequestsstat.controller;

import org.homeprog.customerrequestsstat.service.ValOrInvalCustomerService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValOrInvalCustomerController {
    private final ValOrInvalCustomerService service;

    public ValOrInvalCustomerController(ValOrInvalCustomerService service) {
        this.service = service;
    }

    /*@PostMapping("/api/customers")
    public ValOrInvalCustomer addValOrInvalCustomer(@RequestBody ValOrInvalCustomerDTO customerDTO) {

        Date date = new Date();
        customerDTO.setRequestValidationStatus("invalid");

        ValOrInvalCustomer customer = new ValOrInvalCustomer(customerDTO.getId(),
                customerDTO.getCustomerId(),
                customerDTO.getName(),
                date,
                customerDTO.getRequestValidationStatus());

        return service.addValOrInvalCustomer(customer);
    }*/

}
