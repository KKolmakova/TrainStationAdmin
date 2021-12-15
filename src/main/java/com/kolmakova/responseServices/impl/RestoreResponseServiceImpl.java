package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PaymentDTO;
import com.kolmakova.entities.Payment;
import com.kolmakova.responseServices.RestoreResponseService;
import com.kolmakova.responses.PaymentResponse;
import com.kolmakova.services.PaymentService;
import com.kolmakova.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class RestoreResponseServiceImpl implements RestoreResponseService {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private Converter converter;

    @Override
    public PaymentResponse getResponse(Integer paymentId){
        PaymentResponse paymentResponse = new PaymentResponse();

        Payment payment = paymentService.getPaymentById(paymentId);
        PaymentDTO paymentDTO = converter.convertToPaymentDTO(markAsActing(payment));

        paymentResponse.setPaymentDTO(paymentDTO);

        return paymentResponse;
    }

    private Payment markAsActing(Payment payment){
        payment.setIsDeleted(false);

        return paymentService.savePayment(payment);
    }
}
