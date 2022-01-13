package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PaymentDTO;
import com.kolmakova.entities.Payment;
import com.kolmakova.entities.Pricing;
import com.kolmakova.responseServices.RestorePaymentResponseService;
import com.kolmakova.responses.PaymentInfoResponse;
import com.kolmakova.services.PaymentService;
import com.kolmakova.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class RestorePaymentResponseServiceImpl implements RestorePaymentResponseService {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private Converter converter;

    @Override
    public PaymentInfoResponse getResponse(Integer paymentId) {
        PaymentInfoResponse paymentInfoResponse = new PaymentInfoResponse();

        Payment payment = paymentService.getPaymentById(paymentId);
        PaymentDTO paymentDTO = converter.convertToPaymentDTO(markAsActing(payment));

        paymentInfoResponse.setPaymentDTO(paymentDTO);

        return paymentInfoResponse;
    }

    private Payment markAsActing(Payment payment) {
        Pricing pricing = payment.getPricing();
        if (pricing.getSeatsNumber() > 0) {
            payment.setDeleted(false);
            pricing.setSeatsNumber(pricing.getSeatsNumber() - 1);
        }

        return paymentService.savePayment(payment);
    }
}
