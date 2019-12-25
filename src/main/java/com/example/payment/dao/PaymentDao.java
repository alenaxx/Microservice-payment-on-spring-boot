package com.example.payment.dao;

import com.example.payment.dto.PaymentDto;
import com.example.payment.dto.UserDetailsDto;
import com.example.payment.model.Payment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentDao {

    PaymentDto initPayment(UUID id, UUID orderId, UserDetailsDto userDetails);

    default PaymentDto initPayment(UUID orderId, UserDetailsDto userDetails) {
        UUID id = UUID.randomUUID();
        return initPayment(id,orderId,userDetails);
    }

    PaymentDto getPaymentStatus(UUID orderId);


}
