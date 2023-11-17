package com.projarc.demo.interfaces;

import com.projarc.demo.application.usecase.CEPAtendido_UC;
import com.projarc.demo.application.usecase.CidadesAtendidas_UC;
import com.projarc.demo.application.usecase.CriaOrcamento_UC;
import com.projarc.demo.application.usecase.ListaOrcamentos_UC;
import com.projarc.demo.domain.dto.CidadeDTO;
import com.projarc.demo.domain.dto.OrcamentoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RequestMapping("/calculo-frete")
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
public class CalculoFreteController {

    @Autowired
    private final CidadesAtendidas_UC cidadesAtendidasUC;

    @Autowired
    private final CEPAtendido_UC cepAtendidoUc;

    @Autowired
    private final ListaOrcamentos_UC listaOrcamentosUc;

    @Autowired
    private final CriaOrcamento_UC criaOrcamentoUc;

    @GetMapping("/cidades-atendidas")
    public ResponseEntity<List<CidadeDTO>> getCidadesAtendidas() {
        return ResponseEntity.ok(cidadesAtendidasUC.getCidadesAtendidas());
    }

    @GetMapping("/cep-atendido/{cep}")
    public ResponseEntity<?> cepAtendido(@PathVariable String cep) {
        return ResponseEntity.ok(Map.of("cepAtendido", cepAtendidoUc.cepAtendido(cep)));
    }

    @GetMapping("/orcamento/{dataCriacao}")
    public ResponseEntity<List<OrcamentoDTO>> getOrcamentPorData(@PathVariable LocalDate dataCriacao) {
        log.info("Buscando orcamentos no MS-2 pela data {}", dataCriacao);
        return ResponseEntity.ok(listaOrcamentosUc.getListaOrcamentos(dataCriacao));
    }

    @PostMapping("/orcamento")
    public ResponseEntity<OrcamentoDTO> criaOrcamento(@RequestParam String cepOrigem,
                                                      @RequestParam String cepDestino,
                                                      @RequestParam BigDecimal peso) {
        try {
            return ResponseEntity.ok(criaOrcamentoUc.criarOrcamento(cepOrigem, cepDestino, peso));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from MS-1");
    }
}
