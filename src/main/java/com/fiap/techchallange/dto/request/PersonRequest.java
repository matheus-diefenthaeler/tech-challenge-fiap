package com.fiap.techchallange.dto.request;

import com.fiap.techchallange.entity.Kinship;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class PersonRequest {
    private String name;
    private String cpf;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private Kinship kinship;
    private String sex;
}
