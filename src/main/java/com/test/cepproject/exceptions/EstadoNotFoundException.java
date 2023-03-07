package com.test.cepproject.exceptions;

public class EstadoNotFoundException extends RuntimeException {

    public EstadoNotFoundException() {
        super("Estado não encontrado");
    }
}
