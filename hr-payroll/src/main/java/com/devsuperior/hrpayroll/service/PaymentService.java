package com.devsuperior.hrpayroll.service;

import com.devsuperior.hrpayroll.feignclients.WorkerFeignClient;
import com.devsuperior.hrpayroll.model.Payment;
import com.devsuperior.hrpayroll.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int day) {

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getNome(),worker.getSalarioDiario(), day);
    }
}
