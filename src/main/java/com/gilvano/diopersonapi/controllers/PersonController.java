package com.gilvano.diopersonapi.controllers;

import com.gilvano.diopersonapi.dto.MessageResponseDTO;
import com.gilvano.diopersonapi.entities.Person;
import com.gilvano.diopersonapi.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.create(person);
    }
}
