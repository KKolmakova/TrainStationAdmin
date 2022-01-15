package com.kolmakova.services;

import com.kolmakova.dto.DocumentDTO;
import com.kolmakova.entities.Passenger;

import java.util.List;

public interface PassengerService {

    List<Passenger> getAll();

    Passenger getById(int passengerId);

    List<Passenger> getByParameters(String name, String surname, DocumentDTO documentDTO, String documentSeries);
}
