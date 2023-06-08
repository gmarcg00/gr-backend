package dev.grbackend.controllers;

import dev.grbackend.models.User;
import dev.grbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody User user){
        User userObject = userService.loginUser(user);
        if(userObject != null){
            return new ResponseEntity<>(userObject,HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid credentials",HttpStatus.UNAUTHORIZED);
    }
    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User userObject = this.userService.saveUser(user);
        if(userObject != null){
            return new ResponseEntity<>(userObject, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.CONFLICT);
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
