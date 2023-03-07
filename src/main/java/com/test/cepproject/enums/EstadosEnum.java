package com.test.cepproject.enums;

import com.test.cepproject.exceptions.EstadoNotFoundException;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum EstadosEnum {

    MG(FretePorRegiaoEnum.SUDESTE),
    SP(FretePorRegiaoEnum.SUDESTE),
    ES(FretePorRegiaoEnum.SUDESTE),
    RJ(FretePorRegiaoEnum.SUDESTE),
    AC(FretePorRegiaoEnum.NORTE),
    AP(FretePorRegiaoEnum.NORTE),
    AM(FretePorRegiaoEnum.NORTE),
    PA(FretePorRegiaoEnum.NORTE),
    RO(FretePorRegiaoEnum.NORTE),
    RR(FretePorRegiaoEnum.NORTE),
    TO(FretePorRegiaoEnum.NORTE),
    AL(FretePorRegiaoEnum.NORDESTE),
    BA(FretePorRegiaoEnum.NORDESTE),
    CE(FretePorRegiaoEnum.NORDESTE),
    MA(FretePorRegiaoEnum.NORDESTE),
    PB(FretePorRegiaoEnum.NORDESTE),
    PE(FretePorRegiaoEnum.NORDESTE),
    PI(FretePorRegiaoEnum.NORDESTE),
    RN(FretePorRegiaoEnum.NORDESTE),
    SE(FretePorRegiaoEnum.NORDESTE),
    DF(FretePorRegiaoEnum.CENTRO_OESTE),
    GO(FretePorRegiaoEnum.CENTRO_OESTE),
    MT(FretePorRegiaoEnum.CENTRO_OESTE),
    MS(FretePorRegiaoEnum.CENTRO_OESTE),
    PR(FretePorRegiaoEnum.SUL),
    SC(FretePorRegiaoEnum.SUL),
    RS(FretePorRegiaoEnum.SUL);

    private final FretePorRegiaoEnum frete;

    public static Double getFreteByUF(EstadosEnum uf) {
        EstadosEnum estado = Arrays.stream(EstadosEnum.values())
                .filter(uf::equals)
                .findFirst()
                .orElseThrow(EstadoNotFoundException::new);

        return estado.frete.getFrete();

    }

    public static EstadosEnum getByName(String name) {
        return Arrays.stream(EstadosEnum.values())
                .filter(estado -> estado.name().equals(name))
                .findFirst()
                .orElseThrow(EstadoNotFoundException::new);

    }

}
