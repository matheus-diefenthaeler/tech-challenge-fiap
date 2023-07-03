package com.fiap.techchallange.service;

import com.fiap.techchallange.dto.request.EletroniceDeviceRequest;
import com.fiap.techchallange.dto.response.EletronicDeviceResponse;
import com.fiap.techchallange.entity.EletroniceDevice;
import com.fiap.techchallange.exception.EletronicDeviceNotFoundException;
import com.fiap.techchallange.mapper.EletronicDeviceMapper;
import com.fiap.techchallange.repository.EletronicDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.fiap.techchallange.mapper.EletronicDeviceMapper.modelToResponse;
import static com.fiap.techchallange.mapper.EletronicDeviceMapper.requestToModel;

@Service
@RequiredArgsConstructor
public class EletroniceDeviceService {
    private final EletronicDeviceRepository repository;

    public EletronicDeviceResponse createEletronicDevice(EletroniceDeviceRequest request) {
        EletroniceDevice eletroniceDevice = requestToModel(request);

        EletroniceDevice save = repository.save(eletroniceDevice);
        return modelToResponse(save);
    }

    public EletronicDeviceResponse findById(Long id) {
        Optional<EletroniceDevice> device = repository.findById(id);
        var save = device.orElseThrow(() -> new EletronicDeviceNotFoundException("Eletronic device not found!"));
        return modelToResponse(save);
    }

    public List<EletronicDeviceResponse> findAll() {
        List<EletroniceDevice> eletroniceDeviceList = repository.findAll();
        return EletronicDeviceMapper.toResponseList(eletroniceDeviceList);
    }

    public void deleteById(Long id) {
        Optional<EletroniceDevice> device = repository.findById(id);
        device.ifPresentOrElse(repository::delete, () -> {
            throw new EletronicDeviceNotFoundException("Device not found!");
        });

    }
}
