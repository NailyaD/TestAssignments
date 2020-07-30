package org.homeprog.customerrequestsstat.validation;

import org.homeprog.customerrequestsstat.entity.Customer;

public interface BlackListValidationRule {

    void validate(Customer customer);
}
