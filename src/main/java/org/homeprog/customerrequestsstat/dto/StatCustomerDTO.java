package org.homeprog.customerrequestsstat.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @JsonProperty("timestamp")
    private Instant time;

    private boolean isValid;
}
