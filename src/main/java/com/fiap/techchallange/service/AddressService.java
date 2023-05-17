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

    private final AddressRepository addressRepository;

    public AddressResponse createAddress(AddressRequest request) {
        Address address = requestToModel(request);
        Address save = addressRepository.save(address);
        return modelToResponse(save);
    }
    @Transactional(readOnly = true)
    public AddressResponse getAddress(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        var save = address.orElseThrow(()-> new AddressNotFoundException("Address not found!"));
        return modelToResponse(save);
    }
    public void deleteAddress(Long id) {

        Optional<Address> address = addressRepository.findById(id);
        address.ifPresentOrElse(addressRepository::delete, () -> {
            throw new AddressNotFoundException("Address not found!");
        });
    }
    public List<AddressResponse> getAllAddress() {
        List<Address> address = addressRepository.findAll();
        return modelToResponseList(address);
    }
}
