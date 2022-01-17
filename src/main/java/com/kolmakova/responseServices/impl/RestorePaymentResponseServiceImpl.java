package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PaymentDTO;
import com.kolmakova.entities.Payment;
import com.kolmakova.entities.Pricing;
import com.kolmakova.responseServices.DeletePaymentResponseService;
import com.kolmakova.responseServices.RestorePaymentResponseService;
import com.kolmakova.responses.PaymentInfoResponse;
import com.kolmakova.services.PaymentService;
import com.kolmakova.util.Converter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class RestorePaymentResponseServiceImpl implements RestorePaymentResponseService {

    private static final Logger LOG = Logger.getLogger(RestorePaymentResponseService.class);

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private Converter converter;

    @Override
    public PaymentInfoResponse getResponse(Integer paymentId) {
        PaymentInfoResponse paymentInfoResponse = new PaymentInfoResponse();

        Payment payment = paymentService.getById(paymentId);
        PaymentDTO paymentDTO = converter.convertToPaymentDTO(markAsActing(payment));

        paymentInfoResponse.setPaymentDTO(paymentDTO);

        return paymentInfoResponse;
    }

    private Payment markAsActing(Payment payment) {
        Pricing pricing = payment.getPricing();
        if (pricing.getSeatsNumber() > 0) {
            payment.setDeleted(false);
            pricing.setSeatsNumber(pricing.getSeatsNumber() - 1);

            LOG.info(String.format("Payment number %s on passenger %s %s was mark as active", payment.getId(), payment.getPassenger().getName(), payment.getPassenger().getSurname()));
        }

        return paymentService.save(payment);
    }
}
