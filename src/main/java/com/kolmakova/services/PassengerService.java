package com.kolmakova.services;

import com.kolmakova.entities.Passenger;

import java.util.List;

public interface PassengerService {
    List<Passenger> getAllPassengers();

    Passenger getPassengerById(int passengerId);
}
