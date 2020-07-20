package org.homeprog.customerrequestsstat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "val_or_inval_customer")
@JsonIgnoreProperties(ignoreUnknown=true)
public class ValOrInvalCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @JsonProperty("id")
    private Long id;

    @JoinColumn(name = "customer_id")
    @JsonProperty("customerID")
    private Long customerId;

    @Column(name="name")
    @JsonProperty("customerName")
    private String name;

    @Column(name="time")
    @Temporal(TemporalType.TIMESTAMP)
    //@JsonProperty("timestamp")
    private Date time;

    @Column(name="request_validation_status")
    private String requestValidationStatus;
}
