package com.fiap.techchallange.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonResponse {

    private Long id;
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private String kinship;
    private Long kinshipRelatedTo;
    private String sex;
}
