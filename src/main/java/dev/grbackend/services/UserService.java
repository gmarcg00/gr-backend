package dev.grbackend.services;

import dev.grbackend.models.User;
import dev.grbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<User> getUsers(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public User getByUserName(User user){
        return userRepository.findByUserName(user.getUserName());
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User deleteUser(String userName){
        try{
            return userRepository.deleteByUserName(userName);
        }catch (Exception err){
            return null;
        }
    }
}
