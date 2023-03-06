package com.test.cepproject.controller;

import com.test.cepproject.dto.CepDTO;
import com.test.cepproject.dto.CepResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1")
public class CepController {

    @PostMapping("/consulta-endereco")
    public void consultaEndereco(@RequestBody CepDTO dto) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("https://viacep.com.br/ws/%s/json/", dto.getCep());

        ResponseEntity<CepResponseDTO> response
                = restTemplate.getForEntity(url, CepResponseDTO.class);

        System.out.println(response.getBody());
    }

}
