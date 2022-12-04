package by.tms.service;

import by.tms.entity.Offer;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class OfferService {
    @Autowired
    @Qualifier("inMemoryOfferStorage")
    private Storage<Offer, Long> offerStorage;
}
