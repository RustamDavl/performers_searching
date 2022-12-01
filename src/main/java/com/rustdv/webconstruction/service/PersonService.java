package com.rustdv.webconstruction.service;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePersonDto;
import com.rustdv.webconstruction.dto.read.ReadPersonDto;
import com.rustdv.webconstruction.mapping.CreateUpdatePersonMapper;
import com.rustdv.webconstruction.mapping.ReadPersonMapper;
import com.rustdv.webconstruction.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class PersonService implements IService<CreateUpdatePersonDto, ReadPersonDto, Integer> {

    private final PersonRepository personRepository;
    private final CreateUpdatePersonMapper createUpdatePersonMapper;
    private final ReadPersonMapper readPersonMapper;

    @Transactional
    public ReadPersonDto create(CreateUpdatePersonDto createPersonDto) {

        log.info("create a person");

        return Optional.ofNullable(createPersonDto)
                .map(createUpdatePersonMapper::mapFrom)
                .map(personRepository::save)
                .map(readPersonMapper::mapFrom)
                .orElse(null);
    }

    @Override
    public Optional<ReadPersonDto> findById(Integer id) {

        return personRepository.findById(id)
                .map(readPersonMapper::mapFrom);
    }

    @Transactional
    @Override
    public Optional<ReadPersonDto> update(Integer id, CreateUpdatePersonDto from) {

        return personRepository.findById(id)
                .map(toPerson -> createUpdatePersonMapper.change(from, toPerson))
                .map(personRepository::saveAndFlush)
                .map(readPersonMapper::mapFrom);
    }

    @Transactional
    @Override
    public void delete(Integer id) {

        personRepository.findById(id)
                .ifPresentOrElse(personRepository::delete, () -> {
                    throw new RuntimeException();
                });
    }

    @Override
    public List<ReadPersonDto> findAll() {

        return personRepository.findAll()
                .stream().map(readPersonMapper::mapFrom)
                .toList();
    }

    public Optional<ReadPersonDto> findByEmailAndPassword(String email, String password) {

        return personRepository.findByEmailAndPassword(email, password)
                .map(readPersonMapper::mapFrom);

    }
}
