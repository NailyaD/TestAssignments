package org.homeprog.customerrequestsstat.repository;

import org.homeprog.customerrequestsstat.entity.StatCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface StatRepository extends JpaRepository<StatCustomer, Long> {
    /*@Query(value = "SELECT * FROM request_stats r WHERE r.customer_id = 'customerId' AND DATE (time) = 'dateAndTime'",
            nativeQuery=true)
    List<StatCustomer> findAllByCustomerIdAndTime(@Param("customer_id") Long customerId, @Param("time") Date dateAndTime);*/

    List<StatCustomer> findAllByCustomer_IdAndTime(Long customerId, Date dateAndTime);
}
