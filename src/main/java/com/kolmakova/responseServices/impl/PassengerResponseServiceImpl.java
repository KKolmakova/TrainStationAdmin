package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.DocumentDTO;
import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.entities.Passenger;
import com.kolmakova.repositories.DocumentRepository;
import com.kolmakova.responseServices.PassengerResponseService;
import com.kolmakova.responses.PassengerResponse;
import com.kolmakova.services.PassengerService;
import com.kolmakova.utils.Converter;
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
    private DocumentRepository documentRepository;
    @Autowired
    private Converter converter;

    @Override
    public PassengerResponse getResponse() {
        PassengerResponse passengerResponse = new PassengerResponse();
        passengerResponse.setPassengerDTOList(getAllPassengersDTO());
        passengerResponse.setDocumentDTOList(getAllDocumentDTO());

        return passengerResponse;
    }

    @Override
    public PassengerResponse getSortedResponse(PassengerDTO passengerDTO) {
        PassengerResponse passengerResponse = new PassengerResponse();

        List<Passenger> passengers = passengerService.getByParameters(
                passengerDTO.getName(),
                passengerDTO.getSurname(),
                passengerDTO.getDocumentType(),
                passengerDTO.getDocumentSeries());

        List<PassengerDTO> passengerDTOList = converter.convertToPassengerDTOList(passengers);
        passengerResponse.setPassengerDTOList(passengerDTOList);
        passengerResponse.setDocumentDTOList(getAllDocumentDTO());

        return passengerResponse;
    }

    private List<PassengerDTO> getAllPassengersDTO() {
        List<Passenger> passengers = passengerService.getAllPassengers();
        List<PassengerDTO> passengerDTOList = new ArrayList<>();

        for (Passenger passenger : passengers) {
            passengerDTOList.add(converter.convertToPassengerDTO(passenger));
        }

        return passengerDTOList;
    }

    private List<DocumentDTO> getAllDocumentDTO(){
        return converter.convertToDocumentDTOList(documentRepository.findAll());
    }
}
