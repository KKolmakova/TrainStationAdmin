package com.kolmakova.services;

import com.kolmakova.entities.Payment;

import java.util.List;

public interface PaymentService {

    Payment save(Payment payment);

    Payment getById(int paymentId);

    List<Payment> getByPassengerId(Integer passengerId);
}
