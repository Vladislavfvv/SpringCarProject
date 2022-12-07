package by.tms.service;

import by.tms.entity.User;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    //@Qualifier("inMemoryUserStorage")
    @Qualifier("hibernateUserDao")
    private Storage<User, Long> userService;



    public User save(User user){
        userService.save(user);
        return user;
    }

    public Optional<User> findUserByEmail(String email){
        return userService.findEntity(email);
    }

    public User delete(User user){
        userService.delete(user);
        return user;
    }

    public List<User> getUserList(){
        return userService.getListOfEntity();
    }


}
