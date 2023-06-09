package dev.grbackend.services;


import dev.grbackend.models.User;
import dev.grbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
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
        try{
            return userRepository.save(user);
        }catch (DataIntegrityViolationException e){
            return null;
        }
    }

    public User deleteUser(User user){
        User userObject = userRepository.findByUserName(user.getUserName());
        if(userObject != null){
            userRepository.deleteById(userObject.getId());
            return userObject;
        }
        return null;
    }

}
