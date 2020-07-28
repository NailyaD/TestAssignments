package org.homeprog.customerrequestsstat.repository;

import org.homeprog.customerrequestsstat.entity.BlackListIP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListIPRepository extends JpaRepository<BlackListIP, String> {
    boolean existsBlackListIPByIp(String ip);
}
