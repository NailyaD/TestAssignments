package org.homeprog.customerrequestsstat.repository;

import org.homeprog.customerrequestsstat.entity.StatCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface StatRepository extends JpaRepository<StatCustomer, Long> {
    List<StatCustomer> findAllStatCustomersByCustomerIdAndTimeBetween(Long id, Instant dateFrom, Instant dateTo);
    List<StatCustomer> findAllStatCustomersByCustomerIdAndIsValid(Long id, Boolean isValid);
    List<StatCustomer> findAllStatCustomersByCustomerIdAndIsValidAndTimeBetween
                       (Long id, Boolean isValid, Instant dateFrom, Instant dateTo);
}
