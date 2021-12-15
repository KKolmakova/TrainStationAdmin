package com.kolmakova.responseServices;

import com.kolmakova.responses.PaymentResponse;

public interface RestoreResponseService {

    PaymentResponse getResponse(Integer paymentId);
}
