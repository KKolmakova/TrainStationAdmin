package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.dto.PaymentDTO;
import com.kolmakova.entities.Payment;
import com.kolmakova.responseServices.EditPassengerResponseService;
import com.kolmakova.responses.EditPassengerResponse;
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
public class EditPassengerResponseServiceImpl implements EditPassengerResponseService {

    @Autowired
    private PassengerService passengerService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private Converter converter;

    @Override
    public EditPassengerResponse getResponse(int passengerId) {
        EditPassengerResponse editPassengerResponse = new EditPassengerResponse();

        List<Payment> paymentList = paymentService.getByPassengerId(passengerId);
        List<PaymentDTO> payments = converter.convertToPaymentDTOList(paymentList);

        List<PaymentDTO> deletesPaymentsDTO = new ArrayList<>();
        List<PaymentDTO> paymentDTOList = new ArrayList<>();
        PassengerDTO passengerDTO = converter.convertToPassengerDTO(passengerService.getById(passengerId));

        for (PaymentDTO paymentDTO : payments) {
            if (paymentDTO.isDeleted()) {
                deletesPaymentsDTO.add(paymentDTO);
            } else {
                paymentDTOList.add(paymentDTO);
            }
        }

        editPassengerResponse.setPaymentDTOList(paymentDTOList);
        editPassengerResponse.setDeletedPaymentDTOList(deletesPaymentsDTO);
        editPassengerResponse.setPassengerDTO(passengerDTO);

        return editPassengerResponse;
    }
}
