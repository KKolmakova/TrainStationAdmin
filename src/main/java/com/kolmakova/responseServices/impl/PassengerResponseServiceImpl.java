package com.kolmakova.responseServices.impl;

import com.kolmakova.entities.Passenger;
import com.kolmakova.responseServices.PassengerResponseService;
import com.kolmakova.responses.PassengerResponse;
import com.kolmakova.services.PassengerService;
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

    @Override
    public List<PassengerResponse> getResponse() {
        List<Passenger> passengers = passengerService.getAllPassengers();
        List<PassengerResponse> responseList = new ArrayList<>();

        for (Passenger passenger : passengers) {
            PassengerResponse passengerResponse = new PassengerResponse();
            BeanUtils.copyProperties(passenger, passengerResponse);
            responseList.add(passengerResponse);
        }

        return responseList;
    }
}
