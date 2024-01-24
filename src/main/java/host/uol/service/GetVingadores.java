package host.uol.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import host.uol.model.Vingador;
import host.uol.model.Vingadores;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.ClientInfoStatus;
import java.util.List;

@Service
@Slf4j
public class GetVingadores {

    String URI = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json";

    Vingadores vingadores;

    public GetVingadores() throws JsonProcessingException {
        this.vingadores = getVingadores();
    }

    public Vingadores getVingadores() throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(URI, String.class);
        String json = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        Vingadores listaVingadores = objectMapper.readValue(json, Vingadores.class);

        for (Vingador vingador : listaVingadores.getVingadores()) {
            System.out.println("Codinome: " + vingador.getCodinome());
        }
        return listaVingadores;
    }
}


