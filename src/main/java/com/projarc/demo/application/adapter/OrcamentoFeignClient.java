package com.projarc.demo.application.adapter;

import com.projarc.demo.domain.dto.OrcamentoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "orcamento", url = "http://localhost:8081")
public interface OrcamentoFeignClient {

    @PostMapping(value = "/orcamento/get/{dataCriacao}")
    List<OrcamentoDTO> getOrcamentoPorData(@PathVariable("dataCriacao") String dataCriacao);
}
