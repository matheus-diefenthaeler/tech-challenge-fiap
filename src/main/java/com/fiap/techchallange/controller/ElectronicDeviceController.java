package com.fiap.techchallange.controller;

import com.fiap.techchallange.dto.request.ElectronicDeviceRequest;
import com.fiap.techchallange.dto.response.ElectronicDeviceResponse;
import com.fiap.techchallange.service.ElectronicDeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/device")
public class ElectronicDeviceController {

    private final ElectronicDeviceService service;

    @PostMapping
    public ResponseEntity<ElectronicDeviceResponse> createEletroniceDevice(@RequestBody ElectronicDeviceRequest request, UriComponentsBuilder uriBuilder) {
        ElectronicDeviceResponse response = service.createEletronicDevice(request);
        URI uri = uriBuilder.path("/device/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElectronicDeviceResponse> findById(@PathVariable Long id) {
        ElectronicDeviceResponse response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ElectronicDeviceResponse>> findAll() {
        List<ElectronicDeviceResponse> eletronicDeviceResponseList = service.findAll();
        return ResponseEntity.ok(eletronicDeviceResponseList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
