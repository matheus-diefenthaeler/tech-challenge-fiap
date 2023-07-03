package com.fiap.techchallange.dto.response;

import com.fiap.techchallange.entity.Unit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EletronicDeviceResponse {

    private Long id;
    private String name;
    private String power;
    private String model;
    private String unit;
}
