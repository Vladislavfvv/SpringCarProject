package by.tms.storage;

import by.tms.entity.Seller;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component("InMemorySellerStorage")
public class InMemorySellerStorage
//        implements Storage<Seller, Long>
{

//    private final List<Seller> sellerList = new ArrayList<>();
//    private final AtomicLong sellerIdGenerator = new AtomicLong(0);
//    @Override
//    public Seller save(Seller seller) {
//        seller.setId(sellerIdGenerator.incrementAndGet());
//        sellerList.add(seller);
//        return seller;
//    }
//
//    @Override
//    public Optional<Seller> findById(Long aLong) {
//        for (Seller seller: sellerList) {
//            if(seller.getId() == aLong)
//                return Optional.of(seller);
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public Seller delete(Seller entity) {
//        sellerList.remove(entity);
//        return entity;
//    }
//
//    @Override
//    public List<Seller> getListOfEntity() {
//        return sellerList;
//    }
//
//    @Override
//    public Optional<Seller> findEntity(String email) {
//        for (Seller seller: sellerList) {
//            if(seller.getEmail().equals(email))
//                return Optional.of(seller);
//        }
//        return Optional.empty();
//    }
}
