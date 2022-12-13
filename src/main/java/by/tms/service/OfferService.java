package by.tms.service;

import by.tms.entity.Offer;
import by.tms.entity.AbstractProduct;
import by.tms.entity.User;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferService {
    @Autowired
//    @Qualifier("inMemoryOfferStorage")
    @Qualifier("hibernateOfferDao")
    private Storage<Offer, Long> offerService;

    public Offer save(Offer offer) {
        offerService.save(offer);
        return offer;
    }

    public Offer createOfferWithUserAndVehicleCategory(User user, AbstractProduct abstractProduct){
        Offer offer = new Offer();
        offer.setAbstractProduct(abstractProduct);
        offer.setUser(user);
        return offer;
    }

    public Optional<Offer> findOfferById(Long id) {
        return offerService.findById(id);
    }

    public List<Offer> findOfferByUser(User user){
        return offerService.getListOfEntity().stream().filter(offer -> offer.getUser().equals(user)).collect(Collectors.toList());
    }

    public Offer delete(Offer offer) {
        offerService.delete(offer);
        return offer;
    }

    public  List<Offer> getOfferList() {
        return offerService.getListOfEntity();
    }



}
