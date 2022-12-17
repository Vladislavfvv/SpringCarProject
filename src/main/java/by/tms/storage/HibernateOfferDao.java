package by.tms.storage;

import by.tms.entity.Offer;
import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HibernateOfferDao implements Storage<Offer, Long>{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Offer save(Offer offer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(offer);
        return offer;
    }

    @Override
    public Optional<Offer> findById(Long aLong) {
        Session session = sessionFactory.getCurrentSession();
        Offer optionalOffer = session.createQuery("from Offer", Offer.class).getSingleResult();
        return Optional.of(optionalOffer);
    }

    @Override
    public Offer delete(Offer offer) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(offer);
        return offer;
    }

    @Override
    public List<Offer> getListOfEntity() {
        Session session = sessionFactory.getCurrentSession();
        List<Offer> offerList= session.createQuery("from Offer", Offer.class).getResultList();
        return offerList;
    }

    @Override
    public Optional<Offer> findEntity(String productName) {
        for (Offer o: this.getListOfEntity()) {
            if (o.getAbstractProduct().equals(productName))
                return Optional.of(o);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Offer> findVehicleByOwner(User currentUser) {
        return Optional.empty();
    }
}
