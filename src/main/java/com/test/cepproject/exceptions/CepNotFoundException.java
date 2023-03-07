package com.test.cepproject.exceptions;

public class CepNotFoundException extends RuntimeException {

    public CepNotFoundException() {
        super("Cep não encontrado");
    }
}
