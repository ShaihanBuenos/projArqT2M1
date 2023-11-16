package com.projarc.demo.domain.dto;

import com.projarc.demo.domain.Cidade;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CidadeDTO {
    private Long id;

    private String nome;

    private BigDecimal precoBaseAteSP;

    private BigDecimal precoImposto;

    public static CidadeDTO toDTO(Cidade cidade) {
        return CidadeDTO.builder()
                .id(cidade.getId())
                .nome(cidade.getNome())
                .precoBaseAteSP(cidade.getPrecoBase())
                .precoImposto(cidade.getPrecoImposto())
                .build();
    }
}
