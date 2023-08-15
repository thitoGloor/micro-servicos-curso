package com.devsuperior.hrpayroll.service;

import com.devsuperior.hrpayroll.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(long workerId, int day) {
        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("id", String.valueOf(workerId));
        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariable);
        return new Payment(worker.getNome(),worker.getSalarioDiario(), day);
    }
}
