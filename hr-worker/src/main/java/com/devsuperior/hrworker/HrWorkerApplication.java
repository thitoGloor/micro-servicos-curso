package com.devsuperior.hrworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HrWorkerApplication {

    //TODO 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
    public static void main(String[] args) {
        SpringApplication.run(HrWorkerApplication.class, args);
    }

}
