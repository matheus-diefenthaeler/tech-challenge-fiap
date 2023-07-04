package com.fiap.techchallange.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {
    private Long id;
    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String neighborhood;
}
