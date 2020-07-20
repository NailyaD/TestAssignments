package org.homeprog.customerrequestsstat.service;

import org.homeprog.customerrequestsstat.entity.ValOrInvalCustomer;
import org.homeprog.customerrequestsstat.repository.CustomerRepository;
import org.homeprog.customerrequestsstat.repository.ValOrInvalCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValOrInvalCustomerService {

    private final ValOrInvalCustomerRepository valOrInvalCustomerRepo;
    private final CustomerRepository customerRepo;

    @Autowired
    public ValOrInvalCustomerService(ValOrInvalCustomerRepository valOrInvalCustomerRepo, CustomerRepository customerRepo) {
        this.valOrInvalCustomerRepo = valOrInvalCustomerRepo;
        this.customerRepo = customerRepo;
    }

    public ValOrInvalCustomer addValOrInvalCustomer (ValOrInvalCustomer valOrInvalCustomer) {
        return valOrInvalCustomerRepo.save(valOrInvalCustomer);
    }

}
