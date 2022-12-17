package by.tms.storage;

import by.tms.entity.Offer;
import by.tms.entity.User;

import java.math.BigDecimal;
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
        for (Offer offer : offerList) {
            if (offer.getId() == aLong)
                return Optional.of(offer);
        }
        return Optional.empty();
    }

    @Override
    public Offer delete(Offer entity) {
        offerList.remove(entity);
        return entity;
    }

    @Override
    public List<Offer> getListOfEntity() {
        return offerList;
    }

    @Override
    public Optional<Offer> findEntity(String price) {
        for (Offer offer : offerList) {
            if(offer.getPrice().equals(price))
                return Optional.of(offer);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Offer> findVehicleByOwner(User currentUser) {
        return Optional.empty();
    }
}
