package com.devsuperior.hrpayroll.service;

import com.devsuperior.hrpayroll.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int day) {
        return new Payment("Bob", 300.0, day);
    }
}
