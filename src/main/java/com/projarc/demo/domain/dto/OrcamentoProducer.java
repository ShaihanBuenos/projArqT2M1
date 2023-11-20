package com.projarc.demo.domain.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrcamentoProducer {

    private String cepOrigem;

    private String cepDestino;

    private BigDecimal peso;

}
