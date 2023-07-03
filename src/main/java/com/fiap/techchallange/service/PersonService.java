package com.fiap.techchallange.service;

import com.fiap.techchallange.dto.request.PersonRequest;
import com.fiap.techchallange.dto.response.PersonResponse;
import com.fiap.techchallange.entity.Person;
import com.fiap.techchallange.exception.PersonNotFoundException;
import com.fiap.techchallange.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.fiap.techchallange.mapper.PersonMapper.*;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;


    public PersonResponse createPerson(PersonRequest personRequest) {
        Person person = requestToModel(personRequest);
        Person save = repository.save(person);
        return modelToResponse(save);
    }

    public PersonResponse findById(Long id) {
        Optional<Person> person = repository.findById(id);
        Person save = person.orElseThrow(() -> new PersonNotFoundException("Person Not found!"));
        return modelToResponse(save);

    }

    public List<PersonResponse> findAll() {
        List<Person> personList = repository.findAll();
        return toResponseList(personList);
    }

    public void deleteById(Long id) {
        Optional<Person> person = repository.findById(id);
        person.ifPresentOrElse(repository::delete, () -> {
            throw new PersonNotFoundException("Person Not found!");
        });
    }
}
