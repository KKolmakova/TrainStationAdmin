package com.kolmakova.services.impl;

import com.kolmakova.entities.Payment;
import com.kolmakova.repositories.PaymentRepository;
import com.kolmakova.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getById(int paymentId) {
        return paymentRepository.findById(paymentId).orElse(new Payment());
    }

    @Override
    public List<Payment> getByPassengerId(Integer passengerId) {
        return paymentRepository.getPassengerPayments(passengerId);
    }
}
