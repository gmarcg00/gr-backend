package dev.grbackend.controllers;

import dev.grbackend.models.User;
import dev.grbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ArrayList<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping("/login")
    public ResponseEntity<User> getUser (@RequestBody User user){
        User userObject = userService.getByUserName(user);
        if(userObject != null){
            if(userObject.getPassword().equals(user.getPassword())){
                return new ResponseEntity<>(userObject, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
            }
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @PostMapping("/register")
    public User saveUser(@RequestBody User user) { return this.userService.saveUser(user);
    }

    @DeleteMapping()
    public ResponseEntity<Object> deleteUser(@RequestBody User user){
        User userObject = userService.deleteUser(user);
        if(userObject != null){
            return new ResponseEntity<>(userObject, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Usuario no encontrado.", HttpStatus.NOT_FOUND);
        }
    }
}
