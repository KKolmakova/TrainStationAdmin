package com.kolmakova.responseServices;

import com.kolmakova.responses.PaymentResponse;

public interface DeleteResponseService {

    PaymentResponse getResponse(Integer paymentId);
}
