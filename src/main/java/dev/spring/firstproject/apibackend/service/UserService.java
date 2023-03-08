package dev.spring.firstproject.apibackend.service;

import dev.spring.firstproject.apibackend.model.User;
import dev.spring.firstproject.apibackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository usuarioRepository;

    public ArrayList<User> getAllUsers(){
        return (ArrayList<User>) usuarioRepository.findAll();
    }
    public Optional<User> getUserById(Long id){
        return usuarioRepository.findById(id);
    }
    public ArrayList<User> getUsersByPriority(boolean priority){
        return usuarioRepository.findByPrioridad(priority);
    }
    public User saveUser(User user){
        return usuarioRepository.save(user);
    }
    public boolean deleteUserById(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

}
