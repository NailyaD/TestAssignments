package org.homeprog.customerrequestsstat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ip_blacklist")
public class BlackListIP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ip")
    private Long ip;
}
