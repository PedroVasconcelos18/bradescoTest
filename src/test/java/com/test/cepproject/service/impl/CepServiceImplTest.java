package com.test.cepproject.service.impl;

import com.test.cepproject.dto.CepResponseDTO;
import com.test.cepproject.enums.EstadosEnum;
import com.test.cepproject.enums.FretePorRegiaoEnum;
import com.test.cepproject.exceptions.CepNotFoundException;
import com.test.cepproject.exceptions.EstadoNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CepServiceImplTest {

    public static final String CEP = "31080-150";
    public static final String CEP_ERRADO = "31080-152";
    @InjectMocks // cria uma instancia real
    private CepServiceImpl cepService;

    private CepResponseDTO cepResponseDTO;

    private CepResponseDTO expectedCepResponseDTO;

    @BeforeEach
    void setUp() {
        // realizar trechjo de código antes
        // vai iniciar os mocks dessa classe
        // iniicia o mock da classe atual
        MockitoAnnotations.initMocks(this);
        startCep();
    }

    private void startCep() {
        cepResponseDTO = new CepResponseDTO(CEP, "Rua Cassiterita", "", "Santa Inês",
                "Belo Horizonte", EstadosEnum.MG, FretePorRegiaoEnum.SUDESTE.getFrete());

        expectedCepResponseDTO = new CepResponseDTO(CEP, "Rua Cassiterita", "", "Santa Inês",
                "Belo Horizonte", EstadosEnum.MG, FretePorRegiaoEnum.SUDESTE.getFrete());

    }

    @Test
    void whenConsultaCepThenReturnAnCepResponseDTO() {

        CepResponseDTO response = cepService.consultaCep(CEP);

        assertNotNull(response);
        assertEquals(expectedCepResponseDTO.getCep(), response.getCep());
        assertEquals(expectedCepResponseDTO.getUf(), response.getUf());
        assertEquals(expectedCepResponseDTO.getClass(), response.getClass());

    }

    @Test
    void whenConsultaCepThenReturnAnCepNotFoundException() {

        try {
            cepService.consultaCep(CEP_ERRADO);
        } catch (Exception ex) {
            assertEquals(CepNotFoundException.class, ex.getClass());
            assertEquals("Cep não encontrado", ex.getMessage());
        }

    }

    @Test
    void whenConsultaCepThenReturnAnEstadoNotFoundException() {

        try {
            CepResponseDTO response = cepService.consultaCep(CEP);
            response.setUf(EstadosEnum.getByName(Mockito.anyString()));
        } catch (Exception ex) {
            assertEquals(EstadoNotFoundException.class, ex.getClass());
            assertEquals("Estado não encontrado", ex.getMessage());
        }

    }

}
