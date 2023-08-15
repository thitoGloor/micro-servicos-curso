package com.devsuperior.hrpayroll.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private String nome;
    private Double salarioDiario;
    private Integer day;

    public Double getTotal() {
        return day * salarioDiario;
    }
}
