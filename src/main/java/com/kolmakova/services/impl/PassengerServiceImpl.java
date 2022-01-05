package com.kolmakova.services.impl;

import com.kolmakova.entities.Passenger;
import com.kolmakova.repositories.PassengerRepository;
import com.kolmakova.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger getPassengerById(int passengerId) {
        return passengerRepository.findById(passengerId).orElse(new Passenger());
    }
}
