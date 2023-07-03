package com.fiap.techchallange.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Unit {

    W("W"),
    KW("kW");
    private final String unitName;
}
