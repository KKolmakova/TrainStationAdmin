package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.DocumentDTO;
import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.entities.Passenger;
import com.kolmakova.repositories.DocumentRepository;
import com.kolmakova.responseServices.SortPassengerListResponseService;
import com.kolmakova.responses.PassengerListResponse;
import com.kolmakova.services.PassengerService;
import com.kolmakova.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SortPassengerListResponseServiceImpl implements SortPassengerListResponseService {

    @Autowired
    private PassengerService passengerService;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private Converter converter;

    @Override
    public PassengerListResponse getResponse() {
        PassengerListResponse passengerListResponse = new PassengerListResponse();
        passengerListResponse.setPassengerDTOList(getAllPassengersDTO());
        passengerListResponse.setDocumentDTOList(getAllDocumentDTO());

        return passengerListResponse;
    }

    @Override
    public PassengerListResponse getSortedResponse(PassengerDTO passengerDTO) {
        PassengerListResponse passengerListResponse = new PassengerListResponse();

        List<Passenger> passengers = passengerService.getByParameters(
                passengerDTO.getName(),
                passengerDTO.getSurname(),
                passengerDTO.getDocumentType(),
                passengerDTO.getDocumentSeries());

        List<PassengerDTO> passengerDTOList = converter.convertToPassengerDTOList(passengers);
        passengerListResponse.setPassengerDTOList(passengerDTOList);
        passengerListResponse.setDocumentDTOList(getAllDocumentDTO());

        return passengerListResponse;
    }

    private List<PassengerDTO> getAllPassengersDTO() {
        List<Passenger> passengers = passengerService.getAll();
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
