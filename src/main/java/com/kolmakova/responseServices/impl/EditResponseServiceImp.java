package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.dto.PaymentDTO;
import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Payment;
import com.kolmakova.responseServices.EditResponseService;
import com.kolmakova.responses.EditResponse;
import com.kolmakova.services.PassengerService;
import com.kolmakova.services.PaymentService;
import com.kolmakova.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EditResponseServiceImp implements EditResponseService {

    @Autowired
    private PassengerService passengerService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private Converter converter;

    @Override
    public EditResponse getResponse(int passengerId) {
        EditResponse editResponse = new EditResponse();

        List<Payment> paymentList = paymentService.getPaymentsByPassengerId(passengerId);
        List<PaymentDTO> paymentDTOList = converter.convertToPaymentDTOList(paymentList);

        PassengerDTO passengerDTO = converter.convertToPassengerDTO(passengerService.getPassengerById(passengerId));

        editResponse.setPaymentDTOList(paymentDTOList);
        editResponse.setPassengerDTO(passengerDTO);

        return editResponse;
    }
}
