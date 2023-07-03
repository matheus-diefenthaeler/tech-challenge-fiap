package com.fiap.techchallange.mapper;

import com.fiap.techchallange.dto.request.EletroniceDeviceRequest;
import com.fiap.techchallange.dto.response.EletronicDeviceResponse;
import com.fiap.techchallange.entity.EletroniceDevice;

import java.util.List;
import java.util.stream.Collectors;

public class EletronicDeviceMapper {


    public static EletroniceDevice requestToModel(EletroniceDeviceRequest request){
        EletroniceDevice model = new EletroniceDevice();
        model.setModel(request.getModel());
        model.setName(request.getName());
        model.setUnitName(request.getUnit().getUnitName());
        model.setPower(request.getPower());
        return model;
    }

    public static EletronicDeviceResponse modelToResponse(EletroniceDevice model){
        EletronicDeviceResponse response = new EletronicDeviceResponse();
        response.setId(model.getId());
        response.setUnit(model.getUnitName());
        response.setName(model.getName());
        response.setPower(model.getPower());
        response.setModel(model.getModel());
        return response;
    }

    public static List<EletronicDeviceResponse> toResponseList(List<EletroniceDevice> eletroniceDeviceList){
       return eletroniceDeviceList.stream().map(EletronicDeviceMapper::modelToResponse).collect(Collectors.toList());
    }
}
