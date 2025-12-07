package com.sp.eshopping_payment_service.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "TRANSACTION_DETAILS")
public class TransactionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "ORDER_ID")
    private long orderId;

    @Column(name = "MODE")
    private String paymentMode;

    @Column(name = "REFERENCE_NUMBER")
    private String referenceNumber;

    @Column(name = "PAYMENT_DATE")
    private Instant paymentDate;

    @Column(name = "STATUS")
    private String paymentStatus;

    @Column(name = "AMOUNT")
    private long amount;

    public TransactionDetails() {
    }

    public TransactionDetails(long orderId, String paymentMode, String referenceNumber, Instant paymentDate, String paymentStatus, long amount) {
        this.orderId = orderId;
        this.paymentMode = paymentMode;
        this.referenceNumber = referenceNumber;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TransactionDetails{");
        sb.append("id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", paymentMode='").append(paymentMode).append('\'');
        sb.append(", referenceNumber='").append(referenceNumber).append('\'');
        sb.append(", paymentDate=").append(paymentDate);
        sb.append(", paymentStatus='").append(paymentStatus).append('\'');
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
