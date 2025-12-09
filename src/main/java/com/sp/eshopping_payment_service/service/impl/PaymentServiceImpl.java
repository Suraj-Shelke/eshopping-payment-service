package com.sp.eshopping_payment_service.service.impl;

import com.sp.eshopping_payment_service.entity.TransactionDetails;
import com.sp.eshopping_payment_service.exception.PaymentServiceCustomException;
import com.sp.eshopping_payment_service.payload.request.PaymentRequest;
import com.sp.eshopping_payment_service.payload.response.PaymentResponse;
import com.sp.eshopping_payment_service.repository.TransactionDetailsRepository;
import com.sp.eshopping_payment_service.service.PaymentService;
import com.sp.eshopping_payment_service.utils.PaymentMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;

    @Override
    public long doPayment(PaymentRequest paymentRequest) {

        TransactionDetails transactionDetails = new TransactionDetails();
        transactionDetails.setOrderId(paymentRequest.getOrderId());
        transactionDetails.setReferenceNumber(paymentRequest.getReferenceNumber());
        transactionDetails.setAmount(paymentRequest.getAmount());
        transactionDetails.setPaymentMode(paymentRequest.getPaymentMode().name());
        transactionDetails.setPaymentDate(Instant.now());
        transactionDetails.setPaymentStatus("SUCCESS");

        transactionDetails=transactionDetailsRepository.save(transactionDetails);

        return transactionDetails.getId();
    }

    @Override
    public PaymentResponse getPaymentDetailsByOrderId(long orderId) {

        TransactionDetails transactionDetails
                = transactionDetailsRepository.findByOrderId(orderId)
                .orElseThrow(() -> new PaymentServiceCustomException(
                        "TransactionDetails with given id not found",
                        "TRANSACTION_NOT_FOUND"));


        PaymentResponse paymentResponse=new PaymentResponse();

        paymentResponse.setPaymentId(transactionDetails.getId());
        paymentResponse.setPaymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()));
        paymentResponse.setPaymentDate(transactionDetails.getPaymentDate());
        paymentResponse.setOrderId(transactionDetails.getOrderId());
        paymentResponse.setStatus(transactionDetails.getPaymentStatus());
        paymentResponse.setAmount(transactionDetails.getAmount());

        return paymentResponse;
    }
}
