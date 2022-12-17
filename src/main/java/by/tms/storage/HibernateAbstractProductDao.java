package by.tms.storage;

import by.tms.entity.AbstractProduct;
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
public class HibernateAbstractProductDao implements Storage<AbstractProduct, Long> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public AbstractProduct save(AbstractProduct product) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(product);
        return product;
    }

    @Override
    public Optional<AbstractProduct> findById(Long aLong) {
        Session currentSession = sessionFactory.getCurrentSession();
        AbstractProduct abstractProduct = currentSession.find(AbstractProduct.class, aLong);
        return Optional.of(abstractProduct);
    }

    @Override
    public AbstractProduct delete(AbstractProduct abstractProduct) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(abstractProduct);
        return abstractProduct;
    }

    @Override
    public List<AbstractProduct> getListOfEntity() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from AbstractProduct ", AbstractProduct.class).getResultList();
    }

    @Override
    public Optional<AbstractProduct> findEntity(String productName) {
        for (AbstractProduct product: this.getListOfEntity()) {
            if(product.getNameProduct().equals(productName)){
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<AbstractProduct> findVehicleByOwner(User currentUser) {
        return Optional.empty();
    }
}
