package org.homeprog.customerrequestsstat.service;

import org.homeprog.customerrequestsstat.entity.StatCustomer;
import org.homeprog.customerrequestsstat.repository.StatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class StatService {

    private final StatRepository statRepo;

    @Autowired
    public StatService(StatRepository statRepo) {
        this.statRepo = statRepo;
    }

    public List<StatCustomer> getStatCustomersByCustomerIdAndTimeBetweenTwoDates(long id, Instant dateFrom, Instant dateTo) {
        return statRepo.findAllStatCustomersByCustomerIdAndTimeBetween(id, dateFrom, dateTo);
    }

    public List<StatCustomer> getStatCustomersByCustomerIdAndRequestStatus(Long customerId, boolean isValid) {
        return statRepo.findAllStatCustomersByCustomerIdAndIsValid(customerId, isValid);
    }

    public List<StatCustomer> getStatCustomersByCustomerIdAndRequestStatusAndTimeBetweenTwoDates
           (Long id, boolean isValid, Instant dateFrom, Instant dateTo) {
        return statRepo.findAllStatCustomersByCustomerIdAndIsValidAndTimeBetween(id, isValid, dateFrom, dateTo);
    }
}
