package com.kolmakova.services;

import com.kolmakova.entities.Payment;
import com.kolmakova.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment){
        return paymentRepository.save(payment);
    }

    public Payment getPaymentById(int checkId){
        return paymentRepository.findById(checkId).orElse(new Payment());
    }

    public List<Payment> getPassengerPayments(Integer passengerId){
        return paymentRepository.getPassengerPayments(passengerId);
    }
}
