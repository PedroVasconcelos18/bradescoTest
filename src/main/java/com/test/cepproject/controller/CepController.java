package com.test.cepproject.controller;

import com.test.cepproject.dto.CepDTO;
import com.test.cepproject.dto.CepResponseDTO;
import com.test.cepproject.service.CepService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/v1")
public class CepController {

    private final CepService service;

    public CepController(CepService service) {
        this.service = service;
    }

    @PostMapping("/consulta-endereco")
    @ApiOperation(value = "Encontra as informações do endereço apartir do CEP")
    public CepResponseDTO consultaEndereco(@RequestBody @NotNull CepDTO dto) {
        return service.consultaCep(dto.getCep());
    }

}
