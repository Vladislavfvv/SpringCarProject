package by.tms.storage;

import by.tms.entity.Category;

import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HibernateCategoryDao implements Storage<Category, Long> {

    private final SessionFactory sessionFactory;

    public HibernateCategoryDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Category save(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.save(category);
        return null;
    }

    @Override
    public Optional<Category> findById(Long aLong) {
        Session session = sessionFactory.getCurrentSession();
        Category fromCategory = session.find(Category.class, aLong);
        return Optional.of(fromCategory);
    }


    @Override
    public Category delete(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(category);
        return category;
    }

    @Override
    public List<Category> getListOfEntity() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Category", Category.class).getResultList();

    }

    @Override
    public Optional<Category> findEntity(String parameter) {
        for (Category c: this.getListOfEntity()) {
            if (c.getNameCategory().equals(parameter))
                return Optional.of(c);
        }
        return Optional.empty();
    }
}
