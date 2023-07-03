package com.fiap.techchallange.service;

import com.fiap.techchallange.dto.request.AddressRequest;
import com.fiap.techchallange.dto.response.AddressResponse;
import com.fiap.techchallange.entity.Address;
import com.fiap.techchallange.exception.AddressNotFoundException;
import com.fiap.techchallange.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.fiap.techchallange.mapper.AddressMapper.*;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository repository;

    public AddressResponse createAddress(AddressRequest request) {
        Address address = requestToModel(request);
        Address save = repository.save(address);
        return modelToResponse(save);
    }
    @Transactional(readOnly = true)
    public AddressResponse findById(Long id) {
        Optional<Address> address = repository.findById(id);
        var save = address.orElseThrow(()-> new AddressNotFoundException("Address not found!"));
        return modelToResponse(save);
    }
    public void deleteById(Long id) {

        Optional<Address> address = repository.findById(id);
        address.ifPresentOrElse(repository::delete, () -> {
            throw new AddressNotFoundException("Address not found!");
        });
    }
    public List<AddressResponse> findAll() {
        List<Address> address = repository.findAll();
        return modelToResponseList(address);
    }
}
