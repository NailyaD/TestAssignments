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
@Table(name = "ua_blacklist")
@JsonIgnoreProperties(ignoreUnknown=true)
public class BlackListUserAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ua")
    @JsonProperty("userID")
    private String ua;
}
