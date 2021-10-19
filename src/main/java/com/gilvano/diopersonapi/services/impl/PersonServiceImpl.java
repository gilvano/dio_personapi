package com.gilvano.diopersonapi.services.impl;

import com.gilvano.diopersonapi.dto.MessageResponseDTO;
import com.gilvano.diopersonapi.dto.request.PersonDTO;
import com.gilvano.diopersonapi.entities.Person;
import com.gilvano.diopersonapi.exception.PersonNotFoundException;
import com.gilvano.diopersonapi.mapper.PersonMapper;
import com.gilvano.diopersonapi.repositories.PersonRepository;
import com.gilvano.diopersonapi.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public MessageResponseDTO create(PersonDTO personDTO) {
        Person person = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(person);
        return createMessageResponseDTO(savedPerson, "Created person with ID ");
    }

    @Override
    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    @Override
    public void deleteById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        personRepository.delete(person);
    }

    @Override
    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person person = personMapper.toModel(personDTO);
        Person updatedPerson = personRepository.save(person);
        return createMessageResponseDTO(updatedPerson, "Updated person with ID ");
    }

    private MessageResponseDTO createMessageResponseDTO(Person savedPerson, String msg) {
        return MessageResponseDTO
                .builder()
                .message(msg + savedPerson.getId())
                .build();
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
