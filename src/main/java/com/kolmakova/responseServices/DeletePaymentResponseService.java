package com.kolmakova.responseServices;

import com.kolmakova.responses.PaymentInfoResponse;

public interface DeletePaymentResponseService {

    PaymentInfoResponse getResponse(Integer paymentId);
}
