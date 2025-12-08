package com.sp.eshopping_payment_service.service;

import com.sp.eshopping_payment_service.payload.request.PaymentRequest;
import com.sp.eshopping_payment_service.payload.response.PaymentResponse;

public interface PaymentService {

    long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(long orderId);
}
