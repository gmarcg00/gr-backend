package dev.grbackend.services;


import dev.grbackend.models.User;
import dev.grbackend.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.springframework.dao.DataIntegrityViolationException;

class UserServiceTest {
    static UserService userService;
    static UserRepository userRepository;
    @BeforeAll
    static void setup(){
        userService = new UserService();
        userRepository = PowerMockito.mock(UserRepository.class);
        Whitebox.setInternalState(userService,"userRepository",userRepository);
    }

    @Test
    public void loginCorrectUserTest(){
        User user = new User("guille34","g1234");
        Mockito.when(userRepository.findByUserName(user.getUserName()))
                .thenReturn(new User(Long.parseLong("1"),"guille2345@gmail.com","guille34","g1234"));
        User userResponse = userService.loginUser(user);
        Assertions.assertEquals(user.getUserName(),userResponse.getUserName());
        Assertions.assertEquals(user.getPassword(),userResponse.getPassword());
    }

    @Test
    public void loginIncorrectUserTest(){
        User user = new User("andrew23","and021");
        Mockito.when(userRepository.findByUserName(user.getUserName()))
                .thenReturn(null);
        User userResponse = userService.loginUser(user);
        Assertions.assertEquals(null,userResponse);
    }
    @Test
    public void registerCorrectUserTest(){
        User user = new User("guille2345@gmail.com","g23","g2023");
        Mockito.when(userRepository.save(user))
                .thenReturn(new User(Long.parseLong("1"),"guille2345@gmail.com","guille34","g1234"));
        User userResponse = userService.saveUser(user);
        Assertions.assertEquals(user.getEmail(),userResponse.getEmail());
    }
    @Test
    public void registerInCorrectUserTest(){
        User user = new User("guille2345@gmail.com","g23","g2023");
        Mockito.when(userRepository.save(user))
                .thenThrow(DataIntegrityViolationException.class);
        User userResponse = userService.saveUser(user);
        Assertions.assertEquals(null,userResponse);
    }

    @Test
    public void deleteCorrectUserTest(){
        User user = new User("guille2345@gmail.com","g23","g2023");
        Mockito.when(userRepository.findByUserName(user.getUserName())).thenReturn(new User(Long.parseLong("1"),"guille2345@gmail.com","guille34","g1234"));
        User userResponse = userService.deleteUser(user);
        Assertions.assertEquals(user.getEmail(),userResponse.getEmail());
    }

    @Test
    public void deleteIncorrectUserTest(){
        User user = new User("guille2345@gmail.com","g23","g2023");
        Mockito.when(userRepository.findByUserName(user.getUserName())).thenReturn(null);
        User userResponse = userService.deleteUser(user);
        Assertions.assertEquals(null,userResponse);
    }
}