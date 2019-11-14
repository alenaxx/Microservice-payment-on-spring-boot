package com.example.payment.service;

import com.example.payment.dao.PaymentDao;
import com.example.payment.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {
    private final PaymentDao paymentDao;
    @Autowired
    public PaymentService(@Qualifier("postgres") PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    public int addPayment(Payment payment) {
        return paymentDao.initPayment(payment);
    }



    public   List<Payment> getAllPayments(){
        return paymentDao.getAllPayments();
    }

}
