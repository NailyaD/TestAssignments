package org.homeprog.customerrequestsstat.validation;

import org.homeprog.customerrequestsstat.entity.Customer;
import org.homeprog.customerrequestsstat.repository.BlackListIPRepository;
import org.springframework.stereotype.Component;

@Component
public class IPAddressBlackListRule implements BlackListValidationRule {

    private final BlackListIPRepository blackListIPRepo;

    public IPAddressBlackListRule(BlackListIPRepository blackListIPRepo) {
        this.blackListIPRepo = blackListIPRepo;
    }

    @Override
    public void validate(Customer customer) {
        customer.setValid(!blackListIPRepo.existsBlackListIPByIp(customer.getRemoteIp()));
    }
}
