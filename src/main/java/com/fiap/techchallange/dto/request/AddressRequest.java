package com.fiap.techchallange.dto.request;

import com.fiap.techchallange.entity.State;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressRequest {
    @NotNull(message = "Street is required!")
    private String street;
    @NotNull(message = "Number is required!")
    private String number;
    private String complement;
    @NotNull(message = "City is required!")
    private String city;
    @NotNull(message = "State is required!")
    private State state;
}
