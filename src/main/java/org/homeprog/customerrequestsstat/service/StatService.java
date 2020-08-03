package org.homeprog.customerrequestsstat.service;

import org.homeprog.customerrequestsstat.entity.Customer;
import org.homeprog.customerrequestsstat.repository.StatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StatService {

    private final StatRepository statRepo;

    @Autowired
    public StatService(StatRepository statRepo) {
        this.statRepo = statRepo;
    }

    public List<Customer> getCustomersByCustomerIdAndTimeBetweenTwoDates(long id, LocalDateTime dateFrom, LocalDateTime dateTo) {
        return statRepo.findAllCustomersByDbCustomerIdAndTimeBetween(id, dateFrom, dateTo);
    }

    public List<Customer> getCustomersByCustomerIdAndRequestStatus(Long customerId, boolean isValid) {
        return statRepo.findAllCustomersByDbCustomerIdAndIsValid(customerId, isValid);
    }

    public List<Customer> getCustomersByCustomerIdAndRequestStatusAndTimeBetweenTwoDates
           (Long id, boolean isValid, LocalDateTime dateFrom, LocalDateTime dateTo) {
        return statRepo.findAllCustomersByDbCustomerIdAndIsValidAndTimeBetween(id, isValid, dateFrom, dateTo);
    }
}
