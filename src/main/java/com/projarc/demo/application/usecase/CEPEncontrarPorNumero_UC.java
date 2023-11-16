package com.projarc.demo.application.usecase;

import com.projarc.demo.domain.CEP;
import com.projarc.demo.persistence.CEPSRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CEPEncontrarPorNumero_UC {

    @Autowired
    CEPSRepository cepRepository;

    public Optional<CEP> findByNumero(String cep) {
        return cepRepository.findByNumero(cep);
    }
}
