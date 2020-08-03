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

    //A method that allows setting a valid status of a request as true/false depending on
    // presence JSON userID/remoteIP values in corresponding blacklists
    public void isValidRequest(Customer customer) {
        ipAddressBlackListRule.validate(customer);
        if (customer.isValid()) {
            userAgentBlackListRule.validate(customer);
        }
    }
}
