package com.gilvano.diopersonapi.services.impl;

import com.gilvano.diopersonapi.dto.MessageResponseDTO;
import com.gilvano.diopersonapi.entities.Person;
import com.gilvano.diopersonapi.repositories.PersonRepository;
import com.gilvano.diopersonapi.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public MessageResponseDTO create(Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
}
