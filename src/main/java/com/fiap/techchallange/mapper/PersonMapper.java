package com.fiap.techchallange.mapper;

import com.fiap.techchallange.dto.request.PersonRequest;
import com.fiap.techchallange.dto.response.PersonResponse;
import com.fiap.techchallange.entity.Person;

import java.util.List;
import java.util.stream.Collectors;

public class PersonMapper {

    public static Person requestToModel(PersonRequest request) {
        Person person = new Person();

        person.setName(request.getName());
        person.setCpf(request.getCpf());
        person.setBirthDate(request.getBirthDate());
        person.setKinship(request.getKinship().getKinship().getName());
        person.setKinshipIdRelatedTo(request.getKinship().getPersonId());
        person.setSex(request.getSex());

        return person;
    }

    public static PersonResponse modelToResponse(Person person){
        PersonResponse personResponse = new PersonResponse();

        personResponse.setId(person.getId());
        personResponse.setName(person.getName());
        personResponse.setCpf(person.getCpf());
        personResponse.setBirthDate(person.getBirthDate());
        personResponse.setKinship(person.getKinship());
        personResponse.setKinshipRelatedTo(person.getKinshipIdRelatedTo());
        personResponse.setSex(person.getSex());

        return personResponse;
    }

    public static List<PersonResponse> toResponseList(List<Person> personList){
       return personList.stream().map(PersonMapper::modelToResponse).collect(Collectors.toList());
    }
}
