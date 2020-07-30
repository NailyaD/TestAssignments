package org.homeprog.customerrequestsstat.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.homeprog.customerrequestsstat.validation.NonEmptyValues;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NonEmptyValues
@JsonIgnoreProperties(ignoreUnknown=true)
public class StatCustomerDTO {
    @Nullable
    private Long id;

    @JsonProperty("customerID")
    private Long customerId;

    @JsonProperty("remoteIP")
    private String remoteIp;

    @JsonProperty("userID")
    private String userAgent;

    private LocalDateTime time;

    private boolean isValid;
}
