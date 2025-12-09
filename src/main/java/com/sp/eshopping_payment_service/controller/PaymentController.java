package com.sp.eshopping_payment_service.controller;

import com.sp.eshopping_payment_service.payload.request.PaymentRequest;
import com.sp.eshopping_payment_service.payload.response.PaymentResponse;
import com.sp.eshopping_payment_service.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    Logger log= LoggerFactory.getLogger(PaymentController.class);
    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest) {

        log.info("PaymentController | doPayment is called");
        log.info("PaymentController | doPayment | paymentRequest : " + paymentRequest.toString());
        return new ResponseEntity<>(
                paymentService.doPayment(paymentRequest),
                HttpStatus.OK
        );
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentDetailsByOrderId(@PathVariable long orderId) {
        log.info("PaymentController | getPaymentDetailsByOrderId is called");
        log.info("PaymentController | getPaymentDetailsByOrderId | orderId : " + orderId);
        return new ResponseEntity<>(
                paymentService.getPaymentDetailsByOrderId(orderId),
                HttpStatus.OK
        );
    }
}
