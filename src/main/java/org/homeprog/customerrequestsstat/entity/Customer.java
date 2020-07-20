package org.homeprog.customerrequestsstat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @JsonProperty("customerID")
    private Long id;

    @Column(name="name")
    @JsonProperty("customerName")
    private String name;

    @Column(name="active")
    @JsonProperty("customerStatus")
    private Short status;
}
