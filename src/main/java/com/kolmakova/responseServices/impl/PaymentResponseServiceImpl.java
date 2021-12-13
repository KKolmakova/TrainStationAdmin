package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Payment;
import com.kolmakova.entities.Train;
import com.kolmakova.responseServices.PaymentResponseService;
import com.kolmakova.responses.PaymentResponse;
import com.kolmakova.services.PassengerService;
import com.kolmakova.services.PaymentService;
import com.kolmakova.services.TrainService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PaymentResponseServiceImpl implements PaymentResponseService {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private TrainService trainService;

    @Override
    public PaymentResponse create(PassengerDTO passengerDTO, int trainId) {
        Passenger passenger = savePassenger(passengerDTO);
        Train train = getTrain(trainId);
        Double amount = 100.0;

        Payment payment = Payment.builder()
                .setPassenger(passenger)
                .setTrain(train)
                .setAmount(amount)
                .build();

        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setPayment(paymentService.savePayment(payment));

        return paymentResponse;
    }

    @Override
    public PaymentResponse getResponse(int paymentId) {
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setPassenger(paymentService.getPaymentById(paymentId).getPassenger());
        paymentResponse.setTrain(paymentService.getPaymentById(paymentId).getTrain());

        return paymentResponse;
    }

    private Passenger savePassenger(PassengerDTO passengerDTO) {
        Passenger passenger = new Passenger();
        BeanUtils.copyProperties(passengerDTO, passenger);

        return passengerService.savePassenger(passenger);
    }

    private Train getTrain(int trainId) {
        return trainService.getTrainById(trainId);
    }

}
