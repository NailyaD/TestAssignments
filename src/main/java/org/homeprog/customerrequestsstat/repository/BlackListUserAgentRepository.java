package org.homeprog.customerrequestsstat.repository;

import org.homeprog.customerrequestsstat.entity.BlackListUserAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListUserAgentRepository extends JpaRepository<BlackListUserAgent, String> {
    boolean existsBlackListUserAgentByUa(String ua);
}
