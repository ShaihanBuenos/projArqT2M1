package com.projarc.demo.application.usecase;

import com.projarc.demo.domain.dto.CidadeDTO;
import com.projarc.demo.domain.service.ServicoCidade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CEPAtendido_UC {

    @Autowired
    private final ServicoCidade servicoCidade;

    public List<CidadeDTO> getCidadesAtendidas() {
        return servicoCidade.getCidades();
    }

    public boolean cepAtendido(String numero) {
        return servicoCidade.cepAtendido(numero);
    }
}
