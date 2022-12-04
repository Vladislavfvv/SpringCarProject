package by.tms.storage;

import by.tms.entity.Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryOfferStorage implements Storage<Offer, Long> {

    private final AtomicLong idOfferGenerator = new AtomicLong(0);
    private final List<Offer> offerList = new ArrayList<>();

    @Override
    public Offer save(Offer offer) {
        offer.setId(idOfferGenerator.incrementAndGet());
        offerList.add(offer);
        return offer;
    }

    @Override
    public Optional<Offer> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Offer delete(Offer entity) {
        return null;
    }

    @Override
    public List<Offer> getListOfEntity() {
        return null;
    }

    @Override
    public Optional<Offer> findEntity(String parameter) {
        return Optional.empty();
    }
}
