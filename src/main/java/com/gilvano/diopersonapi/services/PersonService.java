package com.gilvano.diopersonapi.services;

import com.gilvano.diopersonapi.dto.MessageResponseDTO;
import com.gilvano.diopersonapi.entities.Person;

public interface PersonService {
    MessageResponseDTO create(Person person);
}
