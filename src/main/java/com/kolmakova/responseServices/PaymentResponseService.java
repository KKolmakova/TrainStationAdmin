package com.kolmakova.responseServices;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.responses.PaymentResponse;

public interface PaymentResponseService {

    PaymentResponse create(PassengerDTO passengerDTO, int trainId);

    PaymentResponse getResponse(int paymentId);
}
