package host.uol.controller;


import host.uol.model.Vingador;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/teste")
public class TesteException {

    @GetMapping
    public ResponseEntity testaException(){
        log.info("Chamando o end Point");
        Vingador vingador = null;
        vingador.getCodinome();
        return null;
    }

}
