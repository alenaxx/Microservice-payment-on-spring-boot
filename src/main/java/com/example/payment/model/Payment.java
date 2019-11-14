package com.example.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Payment {
    private final UUID paymentId;
    private  final UUID orderId;
    private int status;
    private String username;
    private int cardInfo;

    public UUID getPaymentId() {
        return paymentId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public int getStatus() {
        return status;
    }

    public String getUsername() {
        return username;
    }

    public int getCardInfo() {
        return cardInfo;
    }

    public Payment(@JsonProperty("paymentId") UUID paymentId,
                @JsonProperty("orderId") UUID orderId,
                @JsonProperty("status") int status,
                @JsonProperty("username") String  username,
                @JsonProperty("cardInfo") int cardInfo) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.status = status;
        this.username = username;
        this.cardInfo = cardInfo;
    }
}
