package dev.grbackend.controllers;


import dev.grbackend.models.User;
import dev.grbackend.services.UserService;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.springframework.http.HttpStatus;


class UserControllerTest {
    static UserController userController;
    static UserService userService;

    @BeforeAll
    static void setup(){
        userController = new UserController();
        userService = PowerMockito.mock(UserService.class);
        Whitebox.setInternalState(userController,"userService",userService);
    }

    @Test
    public void loginCorrectUserTest(){
        User user = new User("guille34","g1234");
        Mockito.when(userService.loginUser(user))
                .thenReturn(new User(Long.parseLong("1"),"guille2345@gmail.com","guille34","g1234"));
        var responseEntity = userController.loginUser(user);
        Assertions.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }

    @Test
    public void loginIncorrectUserTest(){
        User user = new User("jorg98","j12");
        Mockito.when(userService.loginUser(user))
                .thenReturn(null);
        var responseEntity = userController.loginUser(user);
        Assertions.assertEquals(HttpStatus.UNAUTHORIZED,responseEntity.getStatusCode());
    }

    @Test
    public void registerCorrectUserTest(){
        User user = new User("jorge@gmail.com","jorg98","j12");
        Mockito.when(userService.saveUser(user))
                .thenReturn(new User(Long.parseLong("2"),"jorge@gmail.com","jorg98","j12"));
        var responseEntity = userController.saveUser(user);
        Assertions.assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
    }

    @Test
    public void registerIncorrectUserTest(){
        User user = new User("jorge@gmail.com","jorg98","j12");
        Mockito.when(userService.saveUser(user))
                .thenReturn(null);
        var responseEntity = userController.saveUser(user);
        Assertions.assertEquals(HttpStatus.CONFLICT,responseEntity.getStatusCode());
    }

}