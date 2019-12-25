package com.example.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Payment {
    private UUID paymentId;
    private UUID orderId;
    private String status;
    private String userName;

    public Payment(
            @JsonProperty("orderId") UUID paymentId,
            @JsonProperty("orderId") UUID orderId,
            @JsonProperty("status") String status,
            String userName) {
        this.paymentId =UUID.randomUUID();
        this.orderId = orderId;
        this.status = status;
        this.userName = userName;
    }

    public Payment() {}

    public UUID getPaymentId() {
        return UUID.randomUUID();
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUsername() { return userName;
    }



   /* private final UUID paymentId;
    private  final UUID orderId;
    private String status;
    private String username;
    private String cardInfo;

    public UUID getPaymentId() {
        return paymentId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public String getUsername() {
        return username;
    }

    public String getCardInfo() {
        return cardInfo;
    }

    public Payment(@JsonProperty("paymentId") UUID paymentId,
                @JsonProperty("orderId") UUID orderId,
                @JsonProperty("status") String status,
                @JsonProperty("username") String  username,
                @JsonProperty("cardInfo") String cardInfo) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.status = status;
        this.username = username;
        this.cardInfo = cardInfo;
    }*/
}
