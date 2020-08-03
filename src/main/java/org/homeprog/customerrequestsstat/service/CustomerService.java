package org.homeprog.customerrequestsstat.service;

import org.homeprog.customerrequestsstat.entity.DBCustomer;
import org.homeprog.customerrequestsstat.entity.Customer;
import org.homeprog.customerrequestsstat.exception.CustomerNotFoundException;
import org.homeprog.customerrequestsstat.repository.DBCustomerRepository;
import org.homeprog.customerrequestsstat.repository.StatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerService {
    private final StatRepository statRepo;
    private final DBCustomerRepository dbCustomerRepo;
    private final ValidationService validationService;

    @Autowired
    public CustomerService(StatRepository statRepo, DBCustomerRepository dbCustomerRepo, ValidationService validationService) {
        this.statRepo = statRepo;
        this.dbCustomerRepo = dbCustomerRepo;
        this.validationService = validationService;
    }

    public Customer addCustomer(Long id, Customer customer) {
        DBCustomer DBCustomer = dbCustomerRepo.getById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        LocalDateTime date = LocalDateTime.now();
        customer.setTime(date);
        validationService.isValidRequest(customer);
        return statRepo.save(customer);
    }
}
