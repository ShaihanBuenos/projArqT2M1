package com.projarc.demo.application.usecase;

import com.projarc.demo.domain.dto.OrcamentoDTO;
import com.projarc.demo.domain.service.ServicoOrcamento;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListaOrcamentos_UC {
    @Autowired
    private final ServicoOrcamento servicoOrcamento;

    public List<OrcamentoDTO> getListaOrcamentos(LocalDate dataOrcamento) {
        return servicoOrcamento.getOrcamentoByDate(dataOrcamento);
    }
}
