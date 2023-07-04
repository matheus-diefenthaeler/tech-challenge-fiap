package com.fiap.techchallange.mapper;

import com.fiap.techchallange.dto.request.AddressRequest;
import com.fiap.techchallange.dto.response.AddressResponse;
import com.fiap.techchallange.entity.Address;

import java.util.List;
import java.util.stream.Collectors;

public class AddressMapper {

    public static Address requestToModel(AddressRequest addressRequest) {
        Address address = new Address();
        address.setStreet(addressRequest.getStreet());
        address.setNumber(addressRequest.getNumber());
        address.setComplement(addressRequest.getComplement());
        address.setCity(addressRequest.getCity());
        address.setState(addressRequest.getState().getAbbreviation());
        address.setNeighborhood(addressRequest.getNeighborhood());
        return address;
    }

    public static AddressResponse modelToResponse(Address address) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(address.getId());
        addressResponse.setStreet(address.getStreet());
        addressResponse.setNumber(address.getNumber());
        addressResponse.setComplement(address.getComplement());
        addressResponse.setCity(address.getCity());
        addressResponse.setState(address.getState());
        addressResponse.setNeighborhood(address.getNeighborhood());
        return addressResponse;
    }

    public static List<AddressResponse> modelToResponseList(List<Address> address) {
        return address.stream().map(AddressMapper::modelToResponse).collect(Collectors.toList());
    }
}
