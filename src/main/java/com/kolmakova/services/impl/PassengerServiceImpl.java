package com.kolmakova.services.impl;

import com.kolmakova.dto.DocumentDTO;
import com.kolmakova.entities.Passenger;
import com.kolmakova.repositories.PassengerRepository;
import com.kolmakova.services.PassengerService;
import com.kolmakova.util.PassengerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public List<Passenger> getAll() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger getById(int passengerId) {
        return passengerRepository.findById(passengerId).orElse(new Passenger());
    }

    @Override
    public List<Passenger> getByParameters(String name, String surname, DocumentDTO documentDTO, String documentSeries) {
        Specification<Passenger> specification = PassengerUtils.getWithParams(name, surname, documentDTO, documentSeries);
        return passengerRepository.findAll(specification);
    }
}
