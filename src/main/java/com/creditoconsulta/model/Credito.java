package com.creditoconsulta.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCredito;
    private String numeroNfse;
    private LocalDate dataConstituicao;
    private BigDecimal valorIssqn;
    private String tipoCredito;
    private boolean simplesNacional;
    private BigDecimal aliquota;
    private BigDecimal valorFaturado;
    private BigDecimal valorDeducao;
    private BigDecimal baseCalculo;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Credito credito = (Credito) o;
        return simplesNacional == credito.simplesNacional && Objects.equals(id, credito.id) && Objects.equals(numeroCredito, credito.numeroCredito) && Objects.equals(numeroNfse, credito.numeroNfse) && Objects.equals(dataConstituicao, credito.dataConstituicao) && Objects.equals(valorIssqn, credito.valorIssqn) && Objects.equals(tipoCredito, credito.tipoCredito) && Objects.equals(aliquota, credito.aliquota) && Objects.equals(valorFaturado, credito.valorFaturado) && Objects.equals(valorDeducao, credito.valorDeducao) && Objects.equals(baseCalculo, credito.baseCalculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroCredito, numeroNfse, dataConstituicao, valorIssqn, tipoCredito, simplesNacional, aliquota, valorFaturado, valorDeducao, baseCalculo);
    }
}
