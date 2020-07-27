package org.homeprog.customerrequestsstat.exception;

import org.homeprog.customerrequestsstat.DTO.CustomerErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(CustomerNotFoundException e, WebRequest request) {
        return handleExceptionInternal(
                e,
                new CustomerErrorDTO(e.getCustomerId(), e.getMessage()),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND,
                request);
    }
}
