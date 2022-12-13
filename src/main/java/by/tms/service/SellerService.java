package by.tms.service;

import by.tms.entity.Seller;
import by.tms.entity.User;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    @Qualifier("hibernateSellerStorage")
    private Storage<Seller, Long> sellerStorage;

    public Seller saveSeller(Seller seller) {
        sellerStorage.save(seller);
        return seller;
    }

    public Optional<Seller> findSellerByEmail(String email) {
        return sellerStorage.findEntity(email);
    }

//    public Seller createSellerFromUser(User user){
//        Seller seller = new Seller();
//        seller.
//
//    }


}
