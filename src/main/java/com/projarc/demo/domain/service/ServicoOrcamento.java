package com.projarc.demo.domain.service;

import com.projarc.demo.domain.dto.OrcamentoDTO;
import com.projarc.demo.application.adapter.OrcamentoFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoOrcamento {

    @Autowired
    OrcamentoFeignClient orcamentoFeignClient;

    public List<OrcamentoDTO> getOrcamentoByDate(LocalDate dataCriacao) {
        return orcamentoFeignClient.getOrcamentoPorData(String.valueOf(dataCriacao));
    }
}
