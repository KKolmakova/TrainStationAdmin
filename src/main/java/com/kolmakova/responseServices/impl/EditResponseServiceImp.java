package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PaymentDTO;
import com.kolmakova.dto.TrainDTO;
import com.kolmakova.entities.Payment;
import com.kolmakova.responseServices.EditResponseService;
import com.kolmakova.responses.EditResponse;
import com.kolmakova.services.PassengerService;
import com.kolmakova.services.PaymentService;
import com.kolmakova.utils.Converter;
import org.hibernate.collection.internal.PersistentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
        List<Payment> paymentDTOList = paymentService.getPassengerPayments(passengerId);
        List<TrainDTO> trainDTOList = new ArrayList<>();

        for (Payment payment : paymentDTOList) {
            trainDTOList.add(converter.convertToTrainDTO(payment.getTrain()));
        }

        editResponse.setTrainDTOList(trainDTOList);
        editResponse.setPassengerDTO(converter.convertToPassengerDTO(passengerService.getPassengerById(passengerId)));

        return editResponse;
    }
}
