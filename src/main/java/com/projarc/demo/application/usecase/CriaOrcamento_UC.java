package com.projarc.demo.application.usecase;

import com.projarc.demo.domain.Orcamento;
import com.projarc.demo.domain.dto.OrcamentoDTO;
import com.projarc.demo.domain.service.ServicoOrcamento;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CriaOrcamento_UC {

    @Autowired
    private final ServicoOrcamento servicoOrcamento;

    public OrcamentoDTO criarOrcamento(String cepOrigem, String cepDestino, BigDecimal peso) {
        Orcamento orcamento = servicoOrcamento.criarOrcamento(cepOrigem, cepDestino, peso);

        return OrcamentoDTO.toDTO(orcamento);
    }
}
