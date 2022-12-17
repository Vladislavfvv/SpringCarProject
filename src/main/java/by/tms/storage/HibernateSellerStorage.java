package by.tms.storage;

import by.tms.entity.Offer;
import by.tms.entity.Seller;
import by.tms.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HibernateSellerStorage implements Storage<Seller, Long>{
    @Override
    public Seller save(Seller entity) {
        return null;
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

    @Override
    public Optional<Seller> findVehicleByOwner(User currentUser) {
        return Optional.empty();
    }
}
