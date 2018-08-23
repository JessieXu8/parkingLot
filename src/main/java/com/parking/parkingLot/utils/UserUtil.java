package com.parking.parkingLot.utils;

public class UserUtil {
    public String getRandomPassword() {
        return String.valueOf((int)(Math.random() * 1000000));
    }
}
