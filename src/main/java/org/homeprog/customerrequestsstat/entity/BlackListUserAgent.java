package org.homeprog.customerrequestsstat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ua_blacklist")
public class BlackListUserAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ua")
    private String ua;
}
