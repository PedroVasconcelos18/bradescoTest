package com.test.cepproject.service.impl;

import com.test.cepproject.dto.CepResponseDTO;
import com.test.cepproject.enums.EstadosEnum;
import com.test.cepproject.exceptions.CepNotFoundException;
import com.test.cepproject.service.CepService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class CepServiceImpl implements CepService {

    @Override
    public CepResponseDTO consultaCep(String cep) {

        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("https://viacep.com.br/ws/%s/json/", cep);

        ResponseEntity<CepResponseDTO> response
                = restTemplate.getForEntity(url, CepResponseDTO.class);

        if (Objects.isNull(response.getBody())) {
            throw new CepNotFoundException();
        }

        String responseCep = response.getBody().getCep();

        if (Objects.nonNull(responseCep)) {
            Double frete = EstadosEnum.getFreteByUF(response.getBody().getUf());
            response.getBody().setFrete(frete);

            return response.getBody();
        } else {
            throw new CepNotFoundException();
        }

    }

}
