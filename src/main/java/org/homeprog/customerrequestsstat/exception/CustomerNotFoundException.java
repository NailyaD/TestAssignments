package org.homeprog.customerrequestsstat.exception;

import lombok.Getter;

public class CustomerNotFoundException extends RuntimeException {

    @Getter
    private final Long customerId;

    public CustomerNotFoundException(Long customerId) {
        super("Customer not found");
        this.customerId = customerId;
    }
}
