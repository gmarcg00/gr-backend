package dev.spring.firstproject.apibackend.controller;

import dev.spring.firstproject.apibackend.model.Game;
import dev.spring.firstproject.apibackend.model.User;
import dev.spring.firstproject.apibackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserService usuarioService;

    @GetMapping
    public ArrayList<User> getAllUsers(){
        return usuarioService.getAllUsers();
    }
    @PostMapping()
    public User saveUser(@RequestBody User user){
        return this.usuarioService.saveUser(user);
    }
    @GetMapping(path = "/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        return usuarioService.getUserById(id);
    }
    @GetMapping("/query")
    public ArrayList<User> getUserById(@RequestParam("prioridad") Boolean priority){
        return usuarioService.getUsersByPriority(priority);
    }
    @GetMapping("/game")
    public Object getGame(){
        String authStr = "66d0c7fd878844b6b062fe3f3822a772";
        String url = "https://api.rawg.io/api/games/the-last-of-us?key="+authStr;

        HttpHeaders headers = new HttpHeaders();

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<Game> response = restTemplate.exchange(url, HttpMethod.GET,request, Game.class);


        return response;
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable("id") Long id){
        boolean userDeleted = usuarioService.deleteUserById(id);
        if(userDeleted){
            return "Usuario con id"+ id +" eliminado correctamente";
        }else{
            return "No se ha podido eliminar el usuario con id "+ id;
        }
    }
}
