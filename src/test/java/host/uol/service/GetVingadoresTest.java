package host.uol.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import host.uol.model.Vingador;
import host.uol.model.Vingadores;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class GetVingadoresTest {


    String URI = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json";

    @Test
    public ResponseEntity<String> getVingadores() throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity(URI, String.class);
        //Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        String json = response.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        Vingadores listaVingadores = objectMapper.readValue(json, Vingadores.class);

        for (Vingador vingador : listaVingadores.getVingadores()) {
            System.out.println("Codinome: ff" + vingador.getCodinome());
        }
        return response;
    }
}