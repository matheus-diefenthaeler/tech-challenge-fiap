package com.fiap.techchallange.service;

import com.fiap.techchallange.dto.request.ElectronicDeviceRequest;
import com.fiap.techchallange.dto.response.ElectronicDeviceResponse;
import com.fiap.techchallange.entity.ElectronicDevice;
import com.fiap.techchallange.exception.ElectronicDeviceNotFoundException;
import com.fiap.techchallange.mapper.ElectronicDeviceMapper;
import com.fiap.techchallange.repository.ElectronicDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.fiap.techchallange.mapper.ElectronicDeviceMapper.modelToResponse;
import static com.fiap.techchallange.mapper.ElectronicDeviceMapper.requestToModel;

@Service
@RequiredArgsConstructor
public class ElectronicDeviceService {
    private final ElectronicDeviceRepository repository;

    public ElectronicDeviceResponse createEletronicDevice(ElectronicDeviceRequest request) {
        ElectronicDevice electronicDevice = requestToModel(request);

        ElectronicDevice save = repository.save(electronicDevice);
        return modelToResponse(save);
    }

    public ElectronicDeviceResponse findById(Long id) {
        Optional<ElectronicDevice> device = repository.findById(id);
        var save = device.orElseThrow(() -> new ElectronicDeviceNotFoundException("Eletronic device not found!"));
        return modelToResponse(save);
    }

    public List<ElectronicDeviceResponse> findAll() {
        List<ElectronicDevice> electronicDeviceList = repository.findAll();
        return ElectronicDeviceMapper.toResponseList(electronicDeviceList);
    }

    public void deleteById(Long id) {
        Optional<ElectronicDevice> device = repository.findById(id);
        device.ifPresentOrElse(repository::delete, () -> {
            throw new ElectronicDeviceNotFoundException("Device not found!");
        });

    }
}
