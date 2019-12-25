package com.example.payment.dto;


import com.example.payment.model.Payment;

import java.util.UUID;

public class PaymentDto {
    private UUID orderId;
    private String status;

    public PaymentDto(UUID orderId, String status) {
        this.orderId=orderId;
        this.status=status;
    }
    public PaymentDto() {
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

    public static PaymentDto fromPayment(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setOrderId(payment.getOrderId());
        paymentDto.setStatus(payment.getStatus());
        return paymentDto;
    }
}
