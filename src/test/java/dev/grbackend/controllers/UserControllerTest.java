package dev.grbackend.controllers;

import dev.grbackend.models.User;
import dev.grbackend.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    @Mock
    UserService userService;
    @InjectMocks
    UserController userController;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void loginUser(){
        User existentUser = new User ("alex23@gmail.com","alex1234","alex-root");
        User nonExistentUser = new User ("alex23@gmail.com","alex1234","alex-root");
        Mockito.when(userService.loginUser(existentUser)).thenReturn(new User ("alex23@gmail.com","alex1234","alex-root"));
        Mockito.when(userService.loginUser(nonExistentUser)).thenReturn(null);

        User actualUser = userService.loginUser(existentUser);
        Assertions.assertEquals(existentUser.getUserName(),actualUser.getUserName());
        actualUser = userService.loginUser(nonExistentUser);
        Assertions.assertEquals(null,actualUser);
    }
}