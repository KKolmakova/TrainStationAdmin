package com.kolmakova.responses;

import com.kolmakova.dto.PaymentDTO;
import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Payment;
import com.kolmakova.entities.Train;

public class PaymentInfoResponse {

    private PaymentDTO paymentDTO;

    public PaymentDTO getPaymentDTO() {
        return paymentDTO;
    }

    public void setPaymentDTO(PaymentDTO paymentDTO) {
        this.paymentDTO = paymentDTO;
    }
}
