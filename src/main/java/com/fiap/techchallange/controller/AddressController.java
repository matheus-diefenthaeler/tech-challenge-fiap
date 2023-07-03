package com.fiap.techchallange.controller;

import com.fiap.techchallange.dto.request.AddressRequest;
import com.fiap.techchallange.dto.response.AddressResponse;
import com.fiap.techchallange.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService service;

    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(@Valid @RequestBody AddressRequest addressRequest, UriComponentsBuilder uriBuilder) {
        AddressResponse addressResponse = service.createAddress(addressRequest);
        URI uri = uriBuilder.path("/address/{id}").buildAndExpand(addressResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(addressResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> findById(@PathVariable Long id) {
        AddressResponse addressResponse = service.findById(id);
        return ResponseEntity.ok(addressResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AddressResponse> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AddressResponse>> findAll() {
        List<AddressResponse> addressResponse = service.findAll();
        return ResponseEntity.ok(addressResponse);
    }

}
