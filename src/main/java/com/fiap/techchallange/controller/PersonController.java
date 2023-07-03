package com.fiap.techchallange.controller;

import com.fiap.techchallange.dto.request.PersonRequest;
import com.fiap.techchallange.dto.response.PersonResponse;
import com.fiap.techchallange.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;

    @PostMapping
    public ResponseEntity<PersonResponse> createPerson(@Valid @RequestBody PersonRequest personRequest, UriComponentsBuilder uriBuilder) {
        PersonResponse personResponse = service.createPerson(personRequest);
        URI uri = uriBuilder.path("/person/{id}").buildAndExpand(personResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(personResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> findById(@PathVariable Long id){
        PersonResponse personResponse = service.findById(id);
        return ResponseEntity.ok(personResponse);
    }

    @GetMapping
    public ResponseEntity<List<PersonResponse>> findAll(){
        List<PersonResponse> personResponseList = service.findAll();
        return ResponseEntity.ok(personResponseList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
