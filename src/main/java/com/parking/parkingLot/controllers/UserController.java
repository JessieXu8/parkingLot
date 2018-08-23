package com.parking.parkingLot.controllers;

import com.parking.parkingLot.entities.User;
import com.parking.parkingLot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("")
    public ResponseEntity addUser(@RequestBody User user) {
        String password = userService.addUser(user);
        if (password.length()>0) {
            return ResponseEntity.status(HttpStatus.CREATED).body(password);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
