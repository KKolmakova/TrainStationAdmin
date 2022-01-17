package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PaymentDTO;
import com.kolmakova.entities.Payment;
import com.kolmakova.entities.Pricing;
import com.kolmakova.responseServices.DeletePaymentResponseService;
import com.kolmakova.responses.PaymentInfoResponse;
import com.kolmakova.services.PaymentService;
import com.kolmakova.util.Converter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DeletePaymentResponseServiceImpl implements DeletePaymentResponseService {

    private static final Logger LOG = Logger.getLogger(DeletePaymentResponseService.class);

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private Converter converter;

    @Override
    public PaymentInfoResponse getResponse(Integer paymentId) {
        PaymentInfoResponse paymentInfoResponse = new PaymentInfoResponse();

        Payment payment = paymentService.getById(paymentId);
        PaymentDTO paymentDTO = converter.convertToPaymentDTO(markAsDeleted(payment));

        paymentInfoResponse.setPaymentDTO(paymentDTO);

        return paymentInfoResponse;
    }

    private Payment markAsDeleted(Payment payment) {
        Pricing pricing = payment.getPricing();
        pricing.setSeatsNumber(pricing.getSeatsNumber() + 1);
        payment.setDeleted(true);

        LOG.info(String.format("Payment number %s on passenger %s %s was mark as deleted", payment.getId(), payment.getPassenger().getName(), payment.getPassenger().getSurname()));
        return paymentService.save(payment);
    }
}
