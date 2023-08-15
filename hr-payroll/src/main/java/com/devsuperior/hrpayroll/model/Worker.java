package com.devsuperior.hrpayroll.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Worker implements Serializable {

    private long id;
    private String nome;
    private Double salarioDiario;
}
