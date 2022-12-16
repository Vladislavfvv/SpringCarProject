package by.tms.storage;

import by.tms.entity.AbstractVehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HibernateCarDao implements Storage<AbstractVehicle, Long> {

    private final SessionFactory sessionFactory;

    public HibernateCarDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public AbstractVehicle save(AbstractVehicle vehicle) {
        Session session = sessionFactory.getCurrentSession();
        session.save(vehicle);
        return vehicle;
    }

    @Override
    public Optional<AbstractVehicle> findById(Long aLong) {
        Session session = sessionFactory.getCurrentSession();
        AbstractVehicle abstractVehicle = session.find(AbstractVehicle.class, aLong);
        return Optional.of(abstractVehicle);
    }

    @Override
    public AbstractVehicle delete(AbstractVehicle vehicle) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(vehicle);
        return vehicle;
    }

    @Override
    public List<AbstractVehicle> getListOfEntity() {
        Session session = sessionFactory.getCurrentSession();
        List<AbstractVehicle> carListList = session.createQuery("from Car", AbstractVehicle.class).getResultList();
        return carListList;
    }

    @Override
    public Optional<AbstractVehicle> findEntity(String nameCar) {
        for (AbstractVehicle a : this.getListOfEntity()) {
            if (a.getNameProduct().equals(nameCar)) {
                return Optional.of(a);
            }
        }
        return Optional.empty();
    }
}
