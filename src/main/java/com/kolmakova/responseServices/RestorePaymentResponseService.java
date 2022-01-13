package com.kolmakova.responseServices;

import com.kolmakova.responses.PaymentInfoResponse;

public interface RestorePaymentResponseService {

    PaymentInfoResponse getResponse(Integer paymentId);
}
