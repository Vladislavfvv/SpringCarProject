package by.tms.storage;

import by.tms.entity.Seller;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component("InMemorySellerStorage")
public class InMemorySellerStorage implements Storage<Seller, Long> {

    private final List<Seller> sellerList = new ArrayList<>();
    private final AtomicLong sellerIdGenerator = new AtomicLong(0);
    @Override
    public Seller save(Seller seller) {
        seller.setId(sellerIdGenerator.incrementAndGet());
        sellerList.add(seller);
        return seller;
    }

    @Override
    public Optional<Seller> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Seller delete(Seller entity) {
        return null;
    }

    @Override
    public List<Seller> getListOfEntity() {
        return null;
    }

    @Override
    public Optional<Seller> findEntity(String parameter) {
        return Optional.empty();
    }
}
