package org.homeprog.customerrequestsstat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValOrInvalCustomerDTO {
    @Nullable
    private Long id;
    private Long customerId;
    private String name;
    private Short status;
    private Long remoteIp;
    private String userAgent;
    @Nullable
    private Date time;
    private String requestValidationStatus;
}
