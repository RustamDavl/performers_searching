package com.rustdv.webconstruction.service;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePersonDto;
import com.rustdv.webconstruction.dto.read.ReadOrderResumeDto;
import com.rustdv.webconstruction.dto.read.ReadPersonDto;
import com.rustdv.webconstruction.dto.read.ReadPersonRoleDto;
import com.rustdv.webconstruction.dto.read.ReadRoleDto;
import com.rustdv.webconstruction.entity.*;
import com.rustdv.webconstruction.mapping.CreateUpdatePersonMapper;
import com.rustdv.webconstruction.mapping.ReadPersonMapper;
import com.rustdv.webconstruction.repository.PersonRepository;
import com.rustdv.webconstruction.repository.PersonRoleRepository;
import com.rustdv.webconstruction.util.ImageLoader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
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

    private final PersonRoleRepository personRoleRepository;

    private final ImageLoader imageLoader;

    @Value("${app.basePersonIcon.path}")
    private final String BASE_PERSON_ICON_FOLDER;

    @Transactional
    public ReadPersonDto create(CreateUpdatePersonDto createUpdatePersonDto) {

        log.info("create a person");

        return Optional.ofNullable(createUpdatePersonDto)
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

    public byte[] getExecutorIcon(Integer id) {

        return personRepository.findById(id)
                .map(Person::getPhoto)
                .map(s -> imageLoader.downloadOneImage(s, BASE_PERSON_ICON_FOLDER))
                .orElse(null);
    }


    @Transactional
    @Override
    public Optional<ReadPersonDto> update(Integer id, CreateUpdatePersonDto from) {

        return personRepository.findById(id)
                .map(toPerson -> createUpdatePersonMapper.update(from, toPerson))
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

    public Optional<ReadPersonDto> findByEmail(String email) {
        return personRepository.findByEmail(email)
                .map(readPersonMapper::mapFrom);


    }

    public Optional<ReadPersonDto> findByEmailAndPassword(String email, String password) {
        return personRepository.findByEmailAndPassword(email, password)
                .map(readPersonMapper::mapFrom);
    }

//    public List<ReadRoleDto> getAllRolesById(Integer id) {
//
//        return personRepository.
//    }


    public List<ReadPersonDto> findRespondedPeople(Integer personId) {


        return personRepository.findById(personId)
                .stream()
                .map(Person::getOrders)
                .flatMap(Collection::stream)
                .map(Order::getOrdersResumeList)
                .flatMap(Collection::stream)
                .map(OrdersResume::getResume)
                .map(Resume::getPerson)
                .map(readPersonMapper::mapFrom)
                .toList();


    }

    public List<ReadPersonDto> findAcceptedResumesByExecutorId(Integer executorId) {

        return personRepository.findById(executorId)
                .stream()
                .map(Person::getResumes)
                .flatMap(Collection::stream)
                .map(Resume::getOrdersResumeList)
                .flatMap(Collection::stream)
                .filter(ordersResume -> ordersResume.getOrderStatus().equals(RespondStatus.ACCEPTED))
                .map(OrdersResume::getOrder)
                .map(Order::getPerson)
                .map(readPersonMapper::mapFrom)
                .toList();
    }

}
