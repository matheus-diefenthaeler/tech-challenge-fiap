package com.fiap.techchallange.mapper;

import com.fiap.techchallange.dto.request.ElectronicDeviceRequest;
import com.fiap.techchallange.dto.response.ElectronicDeviceResponse;
import com.fiap.techchallange.entity.ElectronicDevice;

import java.util.List;
import java.util.stream.Collectors;

public class ElectronicDeviceMapper {


    public static ElectronicDevice requestToModel(ElectronicDeviceRequest request){
        ElectronicDevice model = new ElectronicDevice();
        model.setModel(request.getModel());
        model.setName(request.getName());
        model.setUnitName(request.getUnit().getUnitName());
        model.setPower(request.getPower());
        return model;
    }

    public static ElectronicDeviceResponse modelToResponse(ElectronicDevice model){
        ElectronicDeviceResponse response = new ElectronicDeviceResponse();
        response.setId(model.getId());
        response.setUnit(model.getUnitName());
        response.setName(model.getName());
        response.setPower(model.getPower());
        response.setModel(model.getModel());
        return response;
    }

    public static List<ElectronicDeviceResponse> toResponseList(List<ElectronicDevice> electronicDeviceList){
       return electronicDeviceList.stream().map(ElectronicDeviceMapper::modelToResponse).collect(Collectors.toList());
    }
}
