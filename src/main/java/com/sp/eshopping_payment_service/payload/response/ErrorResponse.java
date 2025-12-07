package com.sp.eshopping_payment_service.payload.response;

public class ErrorResponse {
    private String errorMessage;
    private String errorCode;

    public ErrorResponse() {
    }

    public ErrorResponse(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ErrorResponse{");
        sb.append("errorMessage='").append(errorMessage).append('\'');
        sb.append(", errorCode='").append(errorCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
