package com.fiap.techchallange.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum KinshipName {
    PAI("Pai"),
    MAE("Mãe"),
    IRMAO("Irmão"),
    IRMA("Irmã"),
    TIO("Tio"),
    TIA("Tia"),
    PRIMO("Primo"),
    PRIMA("Prima"),
    AVO("Avó (ô)"),
    SOBRINHO("Sobrinho"),
    SOBRINHA("Sobrinha"),
    NETO("Neto"),
    NETA("Neta");

    private final String name;
}
