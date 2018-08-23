package com.parking.parkingLot.services;

import com.parking.parkingLot.entities.User;
import com.parking.parkingLot.repositories.UserRepository;
import com.parking.parkingLot.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserUtil userUtil = new UserUtil();

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String addUser(User user) {
        User findUser = userRepository.findByUsername(user.getUsername());
        if (findUser!=null)
            return "";
        String password = userUtil.getRandomPassword();
        user.setPassword(password);
        userRepository.save(user);
        return password;
    }
}
