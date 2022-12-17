package by.tms.storage;

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
public class HibernateUserDao implements Storage<User, Long> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long aLong) {
        Session  session = sessionFactory.getCurrentSession();
        User user = session.find(User.class, aLong);
        return Optional.of(user);
    }

    @Override
    public User delete(User user) {
        Session  session = sessionFactory.getCurrentSession();
        session.delete(user);
        return user;
    }

    @Override
    public List<User> getListOfEntity() {
        Session  session = sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User", User.class).getResultList();
        return userList;
    }

    @Override
    public Optional<User> findEntity(String email) {
//        Session  session = sessionFactory.getCurrentSession();

        for (User u: this.getListOfEntity()) {
            if(u.getEmail().equals(email)){
                return Optional.of(u);
            }
        }
//       return Optional.ofNullable(session.createQuery("from User where email=:email", User.class)
//               .setParameter("email", email)
//               .getSingleResult());
        return Optional.empty();
    }

    @Override
    public Optional<User> findVehicleByOwner(User currentUser) {
        return Optional.empty();
    }
}
