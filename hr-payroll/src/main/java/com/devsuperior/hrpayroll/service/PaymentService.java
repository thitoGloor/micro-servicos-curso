package com.devsuperior.hrpayroll.service;

import com.devsuperior.hrpayroll.feignclients.WorkerFeignClient;
import com.devsuperior.hrpayroll.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int day) {

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getNome(),worker.getSalarioDiario(), day);
    }
}
