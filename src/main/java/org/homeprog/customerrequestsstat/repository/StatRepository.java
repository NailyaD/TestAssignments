package org.homeprog.customerrequestsstat.repository;

import org.homeprog.customerrequestsstat.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface StatRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllCustomersByDbCustomerIdAndTimeBetween(Long id, LocalDateTime dateFrom, LocalDateTime dateTo);
    List<Customer> findAllCustomersByDbCustomerIdAndIsValid(Long id, Boolean isValid);
    List<Customer> findAllCustomersByDbCustomerIdAndIsValidAndTimeBetween
                       (Long id, Boolean isValid, LocalDateTime dateFrom, LocalDateTime dateTo);
}
