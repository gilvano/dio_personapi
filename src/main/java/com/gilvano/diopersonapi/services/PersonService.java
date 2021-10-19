package com.gilvano.diopersonapi.services;

import com.gilvano.diopersonapi.dto.MessageResponseDTO;
import com.gilvano.diopersonapi.dto.request.PersonDTO;

public interface PersonService {
    MessageResponseDTO create(PersonDTO personDTO);
}
