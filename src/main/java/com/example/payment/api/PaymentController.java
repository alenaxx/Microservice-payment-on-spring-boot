package com.example.payment.api;


import com.example.payment.model.Payment;
import com.example.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("payment")
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService ;
    }
    @PostMapping(path = "/pay")
    public void addItem(@RequestBody Payment payment) {
        paymentService.addPayment(payment);
    }

    @GetMapping(path = "/pay")
    public List<Payment> getAllItems() {
        return paymentService.getAllPayments();
    }

}
