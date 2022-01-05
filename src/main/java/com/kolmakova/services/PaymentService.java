package com.kolmakova.services;

import com.kolmakova.entities.Payment;

import java.util.List;

public interface PaymentService {
    Payment savePayment(Payment payment);

    Payment getPaymentById(int checkId);

    List<Payment> getPaymentsByPassengerId(Integer passengerId);
}
