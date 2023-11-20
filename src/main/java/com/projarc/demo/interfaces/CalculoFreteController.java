package com.projarc.demo.interfaces;

import com.projarc.demo.application.usecase.CEPAtendido_UC;
import com.projarc.demo.application.usecase.CidadesAtendidas_UC;
import com.projarc.demo.application.usecase.ListaOrcamentos_UC;
import com.projarc.demo.domain.dto.CidadeDTO;
import com.projarc.demo.domain.dto.OrcamentoDTO;
import com.projarc.demo.domain.dto.OrcamentoProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
    private CidadesAtendidas_UC cidadesAtendidasUC;

    @Autowired
    private CEPAtendido_UC cepAtendidoUc;

    @Autowired
    private ListaOrcamentos_UC listaOrcamentosUc;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private FanoutExchange fanout;

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
    public void criaOrcamento(@RequestParam String cepOrigem,
                                                      @RequestParam String cepDestino,
                                                      @RequestParam BigDecimal peso) throws Exception {
        try {
            OrcamentoProducer orcamentoDTO = new OrcamentoProducer(cepOrigem, cepDestino, peso);
            template.convertAndSend(fanout.getName(), "", orcamentoDTO);
        } catch (Exception e) {
            throw new Exception("Erro ao publicar orçamento na fila");
        }
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from MS-1");
    }
}
