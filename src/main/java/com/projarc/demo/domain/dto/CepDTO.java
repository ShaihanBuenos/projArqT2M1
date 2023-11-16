package com.projarc.demo.domain.dto;

import com.projarc.demo.domain.CEP;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CepDTO {
    private Long id;

    private String numero;

    private String cidade;

    public static CepDTO toDTO(CEP cep) {
        return CepDTO.builder()
                .id(cep.getId())
                .numero(cep.getNumero())
                .cidade(cep.getCidade().getNome())
                .build();
    }
}
