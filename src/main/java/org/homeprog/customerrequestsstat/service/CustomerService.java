package org.homeprog.customerrequestsstat.service;

import org.homeprog.customerrequestsstat.entity.Customer;
import org.homeprog.customerrequestsstat.entity.StatCustomer;
import org.homeprog.customerrequestsstat.exception.CustomerNotFoundException;
import org.homeprog.customerrequestsstat.repository.CustomerRepository;
import org.homeprog.customerrequestsstat.repository.StatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final StatRepository statRepo;
    private final CustomerRepository customerRepo;
    private final ValidationService validationService;

    @Autowired
    public CustomerService(StatRepository statRepo, CustomerRepository customerRepo, ValidationService validationService) {
        this.statRepo = statRepo;
        this.customerRepo = customerRepo;
        this.validationService = validationService;
    }

    public StatCustomer addStatCustomer(Long id, StatCustomer statCustomer) {
        Customer customer = customerRepo.getById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        if (validationService.isInvalidRequest(customer, statCustomer)) {
            statCustomer.setValid(false);
            return statRepo.save(statCustomer);
        }
        statCustomer.setValid(true);
        return statRepo.save(statCustomer);
    }
}
