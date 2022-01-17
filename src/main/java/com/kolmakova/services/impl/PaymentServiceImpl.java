package com.kolmakova.services.impl;

import com.kolmakova.entities.Payment;
import com.kolmakova.repositories.PaymentRepository;
import com.kolmakova.services.PaymentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger LOG = Logger.getLogger(PaymentService.class);

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment save(Payment payment) {
        LOG.info(String.format("Payment number %s was update", payment.getId()));
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
