package com.projarc.demo.domain.dto;

import com.projarc.demo.domain.CEP;
import com.projarc.demo.domain.Orcamento;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class OrcamentoDTO {

    private Long id;

    private String origem;

    private String destino;

    private Double peso;

    private BigDecimal custoBase;

    private BigDecimal custoAdicional;

    private BigDecimal valorImpostos;

    private BigDecimal descontoAplicado;

    private BigDecimal valorFinal;

    private LocalDate dataCriacao;

    public static OrcamentoDTO toDTO(Orcamento orcamento) {
        return OrcamentoDTO.builder()
                .id(orcamento.getId())
                .origem(orcamento.getOrigem().getNumero())
                .destino(orcamento.getDestino().getNumero())
                .peso(orcamento.getPeso())
                .custoBase(orcamento.getCustoBase())
                .custoAdicional(orcamento.getCustoAdicional())
                .valorImpostos(orcamento.getValorImpostos())
                .descontoAplicado(orcamento.getDescontoAplicado())
                .valorFinal(orcamento.getValorFinal())
                .dataCriacao(orcamento.getDataCriacao())
                .build();
    }
}
