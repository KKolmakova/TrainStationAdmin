package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.entities.Passenger;
import com.kolmakova.responseServices.PassengerResponseService;
import com.kolmakova.responses.PassengerResponse;
import com.kolmakova.services.PassengerService;
import com.kolmakova.utils.Converter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PassengerResponseServiceImpl implements PassengerResponseService {

    @Autowired
    private PassengerService passengerService;
    @Autowired
    private Converter converter;

    @Override
    public PassengerResponse getResponse() {
        PassengerResponse passengerResponse = new PassengerResponse();
        passengerResponse.setPassengerDTOList(getAllPassengersDTO());

        return passengerResponse;
    }

    private List<PassengerDTO> getAllPassengersDTO(){
        List<Passenger> passengers = passengerService.getAllPassengers();
        List<PassengerDTO> passengerDTOList = new ArrayList<>();

        for (Passenger passenger : passengers) {
            passengerDTOList.add(converter.convertToPassengerDTO(passenger));
        }

        return passengerDTOList;
    }
}
