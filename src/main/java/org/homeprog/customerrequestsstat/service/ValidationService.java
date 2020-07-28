package org.homeprog.customerrequestsstat.service;

import org.homeprog.customerrequestsstat.entity.Customer;
import org.homeprog.customerrequestsstat.entity.StatCustomer;
import org.homeprog.customerrequestsstat.repository.BlackListIPRepository;
import org.homeprog.customerrequestsstat.repository.BlackListUserAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    private final BlackListIPRepository blackListIPRepo;
    private final BlackListUserAgentRepository blackListUARepo;

    @Autowired
    public ValidationService(BlackListIPRepository blackListIPRepo, BlackListUserAgentRepository blackListUARepo) {
        this.blackListIPRepo = blackListIPRepo;
        this.blackListUARepo = blackListUARepo;
    }

    public boolean isInvalidRequest(Customer customer, StatCustomer statCustomer) {
        boolean blackListUserAgent = blackListUARepo.existsBlackListUserAgentByUa(statCustomer.getUserAgent());
        boolean blackListIP = blackListIPRepo.existsBlackListIPByIp(statCustomer.getRemoteIp());

        return  (customer.getStatus() == 0)
                || (blackListUserAgent)
                || (blackListIP)
                || (statCustomer.getUserAgent() == null)
                || (statCustomer.getUserAgent().equals(""))
                || (statCustomer.getRemoteIp() == null)
                || (statCustomer.getRemoteIp().equals(""));
    }
}
