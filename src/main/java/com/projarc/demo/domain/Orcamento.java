package com.projarc.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_origem")
    private CEP origem;

    @ManyToOne
    @JoinColumn(name = "id_destino")
    private CEP destino;

    private Double peso;
    private BigDecimal custoBase;
    private BigDecimal custoAdicional;
    private BigDecimal valorImpostos;
    private BigDecimal descontoAplicado;
    private BigDecimal valorFinal;
    private LocalDate dataCriacao;
}
