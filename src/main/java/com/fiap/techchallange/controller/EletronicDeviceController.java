package com.fiap.techchallange.controller;

import com.fiap.techchallange.dto.request.EletroniceDeviceRequest;
import com.fiap.techchallange.dto.response.EletronicDeviceResponse;
import com.fiap.techchallange.service.EletroniceDeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/device")
public class EletronicDeviceController {

    private final EletroniceDeviceService service;

    @PostMapping
    public ResponseEntity<EletronicDeviceResponse> createEletroniceDevice(@RequestBody EletroniceDeviceRequest request, UriComponentsBuilder uriBuilder) {
        EletronicDeviceResponse response = service.createEletronicDevice(request);
        URI uri = uriBuilder.path("/device/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EletronicDeviceResponse> findById(@PathVariable Long id) {
        EletronicDeviceResponse response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<EletronicDeviceResponse>> findAll() {
        List<EletronicDeviceResponse> eletronicDeviceResponseList = service.findAll();
        return ResponseEntity.ok(eletronicDeviceResponseList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
