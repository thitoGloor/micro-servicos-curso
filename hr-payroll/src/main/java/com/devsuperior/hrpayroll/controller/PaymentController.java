package com.devsuperior.hrpayroll.controller;

import com.devsuperior.hrpayroll.model.Payment;
import com.devsuperior.hrpayroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{day}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer day) {
        Payment payment = service.getPayment(workerId, day);
        return ResponseEntity.ok(payment);
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long worerId, Integer day) {
        Payment payment = new Payment("Thiago Gloor", 400.0, day);
        return ResponseEntity.ok(payment);
    }
}
