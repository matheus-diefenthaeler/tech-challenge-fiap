package com.fiap.techchallange.dto.request;

import com.fiap.techchallange.entity.Unit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectronicDeviceRequest {


    private String name;
    private String power;
    private String model;
    private Unit unit;
}
