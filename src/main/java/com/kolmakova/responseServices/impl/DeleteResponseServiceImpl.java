package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PaymentDTO;
import com.kolmakova.entities.Payment;
import com.kolmakova.entities.Pricing;
import com.kolmakova.responseServices.DeleteResponseService;
import com.kolmakova.responses.PaymentResponse;
import com.kolmakova.services.PaymentService;
import com.kolmakova.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DeleteResponseServiceImpl implements DeleteResponseService {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private Converter converter;

    @Override
    public PaymentResponse getResponse(Integer paymentId) {
        PaymentResponse paymentResponse = new PaymentResponse();

        Payment payment = paymentService.getPaymentById(paymentId);
        PaymentDTO paymentDTO = converter.convertToPaymentDTO(markAsDeleted(payment));

        paymentResponse.setPaymentDTO(paymentDTO);

        return paymentResponse;
    }

    private Payment markAsDeleted(Payment payment) {
        Pricing pricing = payment.getPricing();
        pricing.setSeatsNumber(pricing.getSeatsNumber() + 1);
        payment.setDeleted(true);

        return paymentService.savePayment(payment);
    }
}
