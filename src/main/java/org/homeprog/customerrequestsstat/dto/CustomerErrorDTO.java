package org.homeprog.customerrequestsstat.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerErrorDTO {
    private Long customerId;
    private String message;
    private LocalDateTime date = LocalDateTime.now();

    public CustomerErrorDTO(Long customerId, String message) {
        this.customerId = customerId;
        this.message = message;
    }
}
