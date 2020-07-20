package org.homeprog.customerrequestsstat.repository;

import org.homeprog.customerrequestsstat.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsCustomerById(Long id);
}
