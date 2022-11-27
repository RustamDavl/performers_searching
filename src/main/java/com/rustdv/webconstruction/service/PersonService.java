package com.rustdv.webconstruction.service;

import com.rustdv.webconstruction.dto.createupdate.CreatePersonDto;
import com.rustdv.webconstruction.dto.read.ReadPersonDto;
import com.rustdv.webconstruction.entity.Person;
import com.rustdv.webconstruction.mapping.CreatePersonMapper;
import com.rustdv.webconstruction.mapping.ReadPersonMapper;
import com.rustdv.webconstruction.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    private final CreatePersonMapper createPersonMapper;
    private final ReadPersonMapper readPersonMapper;

    public ReadPersonDto create(CreatePersonDto createPersonDto) {

        return Optional.of(personRepository.save(Person.builder()
                        .email(createPersonDto.getEmail())
                        .password(createPersonDto.getRawPassword())
                        .build()))
                .map(readPersonMapper::mapFrom)
                .orElse(null);

    }
}
