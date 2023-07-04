package com.fiap.techchallange.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectronicDeviceResponse {

    private Long id;
    private String name;
    private String power;
    private String model;
    private String unit;
}
