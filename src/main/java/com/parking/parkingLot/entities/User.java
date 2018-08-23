package com.parking.parkingLot.entities;

import javax.persistence.Entity;

@Entity
public class User {
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }
}
