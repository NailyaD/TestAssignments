package org.homeprog.customerrequestsstat.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = CustomerNonNullRequestValidator.class)
@Target(TYPE)
@Retention(RUNTIME)
public @interface NonNullValues {

    String message() default "All values should be not nulls; UserID and RemoteIP values should be not empty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
