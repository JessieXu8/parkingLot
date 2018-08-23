package com.parking.parkingLot.repositories;

import com.parking.parkingLot.entities.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    UserRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void should_return_user_list_when_call_findByUsername(){
        User savedUser = entityManager.persistFlushFind(new User("Amelia"));
        User user = repository.findByUsername("Amelia");

        Assertions.assertThat(user.getUsername()).isEqualTo(savedUser.getUsername());
    }
}