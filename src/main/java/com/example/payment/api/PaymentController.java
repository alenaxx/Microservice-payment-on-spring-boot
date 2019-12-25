package com.example.payment.api;


import com.example.payment.dto.PaymentDto;
import com.example.payment.dto.UserDetailsDto;
import com.example.payment.model.Payment;
import com.example.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @PostMapping(path = "/{orderId}")
    public ResponseEntity<PaymentDto> initPayment(@PathVariable("orderId") UUID orderId, @RequestBody UserDetailsDto userDetailsDto) {
        return ResponseEntity.ok(paymentService.initPayment(orderId, userDetailsDto));
    }

    @GetMapping(path = "/{orderId}")
    public ResponseEntity<PaymentDto> getPaymentStatus(@PathVariable("orderId") UUID id) {
        PaymentDto paymentDto = paymentService.getPaymentStatus(id);
        if (paymentDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paymentDto);
    }
}
