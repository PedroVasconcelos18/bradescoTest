package com.test.cepproject.dto;

import com.test.cepproject.enums.EstadosEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CepResponseDTO {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private EstadosEnum uf;
    private Double frete;

}
