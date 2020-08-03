package org.homeprog.customerrequestsstat.service;

import org.homeprog.customerrequestsstat.entity.Customer;
import org.homeprog.customerrequestsstat.validation.IPAddressBlackListRule;
import org.homeprog.customerrequestsstat.validation.UserAgentBlackListRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    private final IPAddressBlackListRule ipAddressBlackListRule;
    private final UserAgentBlackListRule userAgentBlackListRule;

    @Autowired
    public ValidationService(IPAddressBlackListRule ipAddressBlackListRule, UserAgentBlackListRule userAgentBlackListRule) {
        this.ipAddressBlackListRule = ipAddressBlackListRule;
        this.userAgentBlackListRule = userAgentBlackListRule;
    }

    public void isValidRequest(Customer customer) {
        ipAddressBlackListRule.validate(customer);
        userAgentBlackListRule.validate(customer);
    }
}
