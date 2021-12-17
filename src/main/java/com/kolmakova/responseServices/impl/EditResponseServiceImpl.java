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
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EditResponseServiceImpl implements EditResponseService {

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
        List<PaymentDTO> payments = converter.convertToPaymentDTOList(paymentList);

        List<PaymentDTO> deletesPaymentsDTO = new ArrayList<>();
        List<PaymentDTO> paymentDTOList = new ArrayList<>();
        PassengerDTO passengerDTO = converter.convertToPassengerDTO(passengerService.getPassengerById(passengerId));

        for (PaymentDTO paymentDTO : payments) {
            if (paymentDTO.isDeleted()) {
                deletesPaymentsDTO.add(paymentDTO);
            } else {
                paymentDTOList.add(paymentDTO);
            }
        }

        editResponse.setPaymentDTOList(paymentDTOList);
        editResponse.setDeletedPaymentDTOList(deletesPaymentsDTO);
        editResponse.setPassengerDTO(passengerDTO);

        return editResponse;
    }
}
