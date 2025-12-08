package com.sp.eshopping_payment_service.exception;

import com.sp.eshopping_payment_service.payload.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PaymentServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleProductServiceException(PaymentServiceCustomException exception) {
        ErrorResponse errorResponse=new ErrorResponse(exception.getMessage(), exception.getErrorCode());
        return new ResponseEntity<> (errorResponse, HttpStatus.NOT_FOUND);
    }
}
