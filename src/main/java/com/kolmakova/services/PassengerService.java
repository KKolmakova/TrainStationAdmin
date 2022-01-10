package com.kolmakova.services;

import com.kolmakova.dto.DocumentDTO;
import com.kolmakova.entities.Passenger;
import com.kolmakova.types.DocumentType;

import java.util.List;

public interface PassengerService {
    List<Passenger> getAllPassengers();

    Passenger getPassengerById(int passengerId);

    List<Passenger> getByParameters(String name, String surname, DocumentDTO documentDTO, String documentSeries);
}
