package com.devsuperior.hrpayroll.controller;

import com.devsuperior.hrpayroll.model.Payment;
import com.devsuperior.hrpayroll.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @GetMapping(value = "/{workerId}/days/{day}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer day) {
        Payment payment = service.getPayment(workerId, day);
        return ResponseEntity.ok(payment);
    }
}
