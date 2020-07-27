package org.homeprog.customerrequestsstat.service;

import org.homeprog.customerrequestsstat.entity.Customer;
import org.homeprog.customerrequestsstat.entity.StatCustomer;
import org.homeprog.customerrequestsstat.exception.CustomerNotFoundException;
import org.homeprog.customerrequestsstat.repository.BlackListIPRepository;
import org.homeprog.customerrequestsstat.repository.BlackListUserAgentRepository;
import org.homeprog.customerrequestsstat.repository.CustomerRepository;
import org.homeprog.customerrequestsstat.repository.StatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class StatService {

    private final StatRepository statRepo;
    private final CustomerRepository customerRepo;
    private final BlackListIPRepository blackListIPRepo;
    private final BlackListUserAgentRepository blackListUARepo;

    @Autowired
    public StatService(StatRepository statRepo, CustomerRepository customerRepo,
                       BlackListIPRepository blackListIPRepo, BlackListUserAgentRepository blackListUARepo) {
        this.statRepo = statRepo;
        this.customerRepo = customerRepo;
        this.blackListIPRepo = blackListIPRepo;
        this.blackListUARepo = blackListUARepo;
    }

    public StatCustomer addStatCustomer(Long id, StatCustomer statCustomer) {
        Customer customer = customerRepo.getById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        if (isInvalidRequest(customer, statCustomer)) {
            statCustomer.setValid(false);
            return statRepo.save(statCustomer);
        }
        statCustomer.setValid(true);
        return statRepo.save(statCustomer);
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

    public boolean isInvalidRequest(Customer customer, StatCustomer statCustomer) {
        boolean blackListUserAgent = blackListUARepo.existsBlackListUserAgentByUa(statCustomer.getUserAgent());
        boolean blackListIP = blackListIPRepo.existsBlackListIPByIp(statCustomer.getRemoteIp());

        return  (customer.getStatus() == 0)
                || (blackListUserAgent)
                || (blackListIP)
                || (statCustomer.getUserAgent() == null)
                || statCustomer.getUserAgent().equals("")
                || (statCustomer.getRemoteIp() == null);
    }
}
