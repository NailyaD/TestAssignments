package org.homeprog.customerrequestsstat.service;

import org.homeprog.customerrequestsstat.entity.StatCustomer;
import org.homeprog.customerrequestsstat.repository.StatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatService {

    private final StatRepository statRepo;

    @Autowired
    public StatService(StatRepository statRepo) {
        this.statRepo = statRepo;
    }

    public StatCustomer addStatCustomer(StatCustomer statCustomer) {
        return statRepo.save(statCustomer);
    }

    /*TODO
    public List<StatCustomer> getCustomerStatisticsByDate(Long id, Date dateAndTime) {
        return statRepo.findAllByCustomer_IdAndTime(id, dateAndTime);
    }*/

    /*public List<StatCustomer> getCustomerStatisticsByValidationStatus(Long id, boolean isValid) {
        return statRepo.findAll();
    }*/

    /*public List<StatCustomer> getCustomerStatisticsByDateAndValidationStatus(Long id, Date date, boolean isValid) {
        return statRepo.findAll();
    }*/

    /*public boolean isValid(StatCustomer statCustomer) {
        return true;
    }*/
}
