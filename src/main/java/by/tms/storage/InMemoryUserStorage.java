package by.tms.storage;

import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component("inMemoryUserStorage")
public class InMemoryUserStorage implements Storage<User, Long> {

    public List<User> userList = new ArrayList<>();
    private final AtomicLong userIdGenerator = new AtomicLong(0);

    @Override
    public User save(User user) {
        user.setId(userIdGenerator.incrementAndGet());
        userList.add(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long aLong) {
        for (User u : userList) {
            if (u.getId() == aLong) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

    @Override
    public User delete(User user) {
        userList.remove(user);
        return user;
    }

    @Override
    public List<User> getListOfEntity() {
        return userList;
    }

    @Override
    public Optional<User> findEntity(String email) {
        for (User u : userList) {
            if (u.getEmail().equals(email)) {
                Optional.of(u);
            }
        }
        return Optional.empty();
    }
}
