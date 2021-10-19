package com.gilvano.diopersonapi.services;

import com.gilvano.diopersonapi.dto.MessageResponseDTO;
import com.gilvano.diopersonapi.dto.request.PersonDTO;

import java.util.List;

public interface PersonService {
    MessageResponseDTO create(PersonDTO personDTO);

    List<PersonDTO> listAll();
}
