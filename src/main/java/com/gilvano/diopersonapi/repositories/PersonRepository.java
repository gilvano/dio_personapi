package com.gilvano.diopersonapi.repositories;

import com.gilvano.diopersonapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person, Long> {
}
