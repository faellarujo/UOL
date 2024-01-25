package host.uol.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import host.uol.config.ConfigURL;
import host.uol.model.Vingador;
import host.uol.model.Vingadores;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
@Slf4j
public class GetVingadores {

    Vingadores vingadores;

    public GetVingadores() throws IOException {
        final ConfigURL configURL = new ConfigURL();
        this.vingadores = getVingadores(configURL.getVingadoresUrl());
    }

    public Vingadores getVingadores(String uri) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        String json = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        Vingadores listaVingadores = objectMapper.readValue(json, Vingadores.class);

        for (Vingador vingador : listaVingadores.getVingadores()) {
            System.out.println("Codinome: " + vingador.getCodinome());
        }
        return listaVingadores;
    }

    public static void main(String[] args) throws IOException {
        final ConfigURL configURL = new ConfigURL();
        try {
           final GetVingadores vingadores = new GetVingadores();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


