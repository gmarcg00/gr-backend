package dev.grbackend.services;


import dev.grbackend.models.User;
import dev.grbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUsers(){
        return (List<User>) userRepository.findAll();
    }

    public User loginUser(User user){
        User userObject = userRepository.findByUserName(user.getUserName());
        if(userObject != null) {
            if(userObject.getPassword().equals(user.getPassword())) {
                return userObject;
            }
        }
        return null;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public User deleteUser(User user){
        User isUser = loginUser(user);
        if(isUser != null){
            userRepository.deleteById(isUser.getId());
            return isUser;
        }
        return null;
    }

}
