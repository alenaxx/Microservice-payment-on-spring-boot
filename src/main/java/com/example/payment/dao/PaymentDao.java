package com.example.payment.dao;

import com.example.payment.model.Payment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentDao {

    int addPayment(UUID id, Payment payment);

    default int initPayment(Payment payment) {
        UUID id = UUID.randomUUID();
        return addPayment(id, payment);
    }


    List<Payment> getAllPayments();

}
