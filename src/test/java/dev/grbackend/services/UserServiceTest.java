package dev.grbackend.services;

import dev.grbackend.models.User;
import dev.grbackend.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;


class UserServiceTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;
    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getUsers() {
        List<User> expectedUserList = new ArrayList<>();
        User user1 = new User ("guillermo.1930@live.com","guille02","g1234");
        User user2= new User ("alex23@gmail.com","alex1234","alex-root");
        expectedUserList.add(user1);
        expectedUserList.add(user2);

        Mockito.when(userRepository.findAll()).thenReturn(expectedUserList);
        List<User> actualUserList = userService.getUsers();

        for(int i = 0 ; i<expectedUserList.size(); i++){
            Assertions.assertEquals(expectedUserList.get(i).getUserName(),actualUserList.get(i).getUserName());
            Assertions.assertEquals(expectedUserList.get(i).getEmail(),actualUserList.get(i).getEmail());
            Assertions.assertEquals(expectedUserList.get(i).getPassword(),actualUserList.get(i).getPassword());
        }
    }
    @Test
    void getByUserName() {
        User expectedUser = new User ("guillermo.1930@live.com","guille02","g1234");
        Mockito.when(userRepository.findByUserName(expectedUser.getUserName())).thenReturn(new User ("guillermo.1930@live.com","guille02","g1234"));
        User actualUser = userService.getByUserName(expectedUser);
        Assertions.assertEquals(expectedUser.getUserName(),actualUser.getUserName());
        Assertions.assertEquals(expectedUser.getEmail(),actualUser.getEmail());
        Assertions.assertEquals(expectedUser.getPassword(),actualUser.getPassword());
    }

    @Test
    void saveUser() {
        User expectedUser = new User ("alex23@gmail.com","alex1234","alex-root");
        Mockito.when(userRepository.save(expectedUser)).thenReturn(new User ("alex23@gmail.com","alex1234","alex-root"));
        User actualUser = userService.saveUser(expectedUser);
        Assertions.assertEquals(expectedUser.getUserName(),actualUser.getUserName());
        Assertions.assertEquals(expectedUser.getEmail(),actualUser.getEmail());
        Assertions.assertEquals(expectedUser.getPassword(),actualUser.getPassword());
    }
/*
    @Test
    void deleteUser() {
        User expectedUser = userService.getByUserName(new User ("user3@live.com","user3","user3-1234"));
        Mockito.when(userService.deleteUser(expectedUser)).thenReturn(new User ("user3@live.com","user3","user3-1234"));
        User actualUser = userService.deleteUser(expectedUser);
        Assertions.assertEquals(expectedUser.getUserName(),actualUser.getUserName());
        Assertions.assertEquals(expectedUser.getEmail(),actualUser.getEmail());
        Assertions.assertEquals(expectedUser.getPassword(),actualUser.getPassword());
    }
 */
}