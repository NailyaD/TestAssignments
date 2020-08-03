package org.homeprog.customerrequestsstat.repository;

import org.homeprog.customerrequestsstat.entity.DBCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DBCustomerRepository extends JpaRepository<DBCustomer, Long> {
    Optional<DBCustomer> getById(Long id);
}
