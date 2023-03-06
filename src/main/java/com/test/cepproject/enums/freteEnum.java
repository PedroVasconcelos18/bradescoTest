package com.test.cepproject.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum freteEnum {

    SUDESTE(7.85),
    CENTRO_OESTE(12.50),
    NORDESTE(15.98),
    SUL(17.30),
    NORTE(20.83);

    private final Double frete;

}
