package com.parking.parkingLot.controllers.services;

import com.parking.parkingLot.entities.User;
import com.parking.parkingLot.repositories.UserRepository;
import com.parking.parkingLot.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @Test
    public void should_return_password_when_add_user_successful(){
        UserService userService = new UserService(userRepository);
        User user = new User("Jessie");

        when(userRepository.findByUsername(user.getUsername())).thenReturn(null);
        when(userRepository.save(user)).thenReturn(user);
        userService.addUser(user);
        verify(userRepository).save(user);

    }
    @Test
    public void should_return_null_string_when_add_user_failed(){
        UserService userService = new UserService(userRepository);
        User user = new User("Jessie");

        when(userRepository.findByUsername(user.getUsername())).thenReturn(user);

        String password = userService.addUser(user);
        assertThat(password,is(""));

    }

}
