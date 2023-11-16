package com.projarc.demo.domain.service;

import com.projarc.demo.application.usecase.CEPEncontrarPorNumero_UC;
import com.projarc.demo.domain.CEP;
import com.projarc.demo.domain.Cidade;
import com.projarc.demo.domain.dto.CidadeDTO;
import com.projarc.demo.persistence.CEPSRepository;
import com.projarc.demo.persistence.CidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicoCidade {
    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    CEPEncontrarPorNumero_UC cepEncontrarPorNumero_uc;

    public List<CidadeDTO> getCidades() {
        return cidadeRepository.findAll().stream().map(CidadeDTO::toDTO).toList();
    }

    public boolean cepAtendido(String cep) {
        Optional<CEP> cepOpt = cepEncontrarPorNumero_uc.findByNumero(cep);

        if (cepOpt.isPresent()) {
            Long idCidade = cepOpt.get().getCidade().getId();

            return cidadeRepository.existsById(idCidade);
        } else {
            return false;
        }
    }
}
