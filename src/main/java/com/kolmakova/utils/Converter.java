package com.kolmakova.utils;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.dto.PaymentDTO;
import com.kolmakova.dto.TrainDTO;
import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Payment;
import com.kolmakova.entities.Train;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {

    public TrainDTO convertToTrainDTO(Train train) {
        TrainDTO trainDTO = new TrainDTO();
        BeanUtils.copyProperties(train, trainDTO);

        return trainDTO;
    }

    public PassengerDTO convertToPassengerDTO(Passenger passenger) {
        PassengerDTO passengerDTO = new PassengerDTO();
        BeanUtils.copyProperties(passenger, passengerDTO);

        return passengerDTO;
    }

    public PaymentDTO convertToPaymentDTO(Payment payment){
        PaymentDTO paymentDTO = new PaymentDTO();
        BeanUtils.copyProperties(payment, paymentDTO);

        return paymentDTO;
    }

    public List<PaymentDTO> convertToPaymentDTOList(List<Payment> paymentList) {
       List<PaymentDTO> paymentDTOList = new ArrayList<>();

        for (Payment payment : paymentList) {
            paymentDTOList.add(convertToPaymentDTO(payment));
        }

        return paymentDTOList;
    }
}
