package org.homeprog.customerrequestsstat.validation;

import org.homeprog.customerrequestsstat.entity.Customer;
import org.homeprog.customerrequestsstat.repository.BlackListUserAgentRepository;
import org.springframework.stereotype.Component;

@Component
public class UserAgentBlackListRule implements BlackListValidationRule {

    private final BlackListUserAgentRepository blackListUARepo;

    public UserAgentBlackListRule(BlackListUserAgentRepository blackListUARepo) {
        this.blackListUARepo = blackListUARepo;
    }

    @Override
    public void validate(Customer customer) {
        customer.setValid(!blackListUARepo.existsBlackListUserAgentByUa(customer.getUserAgent()));
    }
}
