package org.homeprog.customerrequestsstat.validation;

import org.homeprog.customerrequestsstat.DTO.CustomerDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//A validator that allows rejecting all invalid requests (requests that contain null or empty values)
public class CustomerNonNullRequestValidator implements ConstraintValidator<NonNullValues, CustomerDTO> {

    @Override
    public void initialize(NonNullValues constraintAnnotation) {

    }

    @Override
    public boolean isValid(CustomerDTO customerDTO, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("CUSTOMER " + customerDTO.getCustomerId());
        return  customerDTO.getCustomerId() != null
                && customerDTO.getRemoteIp() != null
                && customerDTO.getUserAgent() != null
                && !customerDTO.getUserAgent().equals("")
                && !customerDTO.getRemoteIp().equals("");
    }
}
