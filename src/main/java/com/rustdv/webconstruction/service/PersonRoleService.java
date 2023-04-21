package com.rustdv.webconstruction.service;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePersonDto;
import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePersonRoleDto;
import com.rustdv.webconstruction.dto.read.ReadOrderResumeDto;
import com.rustdv.webconstruction.dto.read.ReadPersonRoleDto;
import com.rustdv.webconstruction.dto.read.ReadRoleDto;
import com.rustdv.webconstruction.entity.PersonRole;
import com.rustdv.webconstruction.entity.Role;
import com.rustdv.webconstruction.entity.Roles;
import com.rustdv.webconstruction.mapping.ReadPersonMapper;
import com.rustdv.webconstruction.mapping.ReadPersonRoleMapper;
import com.rustdv.webconstruction.mapping.ReadRoleMapper;
import com.rustdv.webconstruction.repository.PersonRepository;
import com.rustdv.webconstruction.repository.PersonRoleRepository;
import com.rustdv.webconstruction.util.ImageLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonRoleService implements IService<CreateUpdatePersonRoleDto, ReadPersonRoleDto, Integer> {

    private final PersonService personService;
    private final PersonRoleRepository personRoleRepository;
    private final RoleService roleService;
    private final ReadRoleMapper readRoleMapper;
    private final ReadPersonMapper readPersonMapper;
    private final ReadPersonRoleMapper readPersonRoleMapper;

    private final ImageLoader imageLoader;





    @Override
    public ReadPersonRoleDto create(CreateUpdatePersonRoleDto object) {

        var roles = roleService.findAll();



        //create a person and then save him
        var createUpdatePersonDto = CreateUpdatePersonDto.builder()
                .firstName(object.getFirstName())
                .rawPassword(object.getRawPassword())
                .role(object.getRole())
                .photo("pngwing.com (1).png")
                .email(object.getEmail())
                .build();
        var person = readPersonMapper.mapFrom(personService.create(createUpdatePersonDto));

        roles.stream()
                .map(readRoleMapper::mapFrom)
                .forEach(role -> {
                    var personRole = PersonRole.builder()
                            .role(role)
                            .person(person)
                            .build();
                    personRole.addPerson(person);
                    personRole.addRole(role);
                    readPersonRoleMapper.mapFrom(
                            personRoleRepository.save(personRole));
                });


        return ReadPersonRoleDto.builder()
                .readPersonDto(readPersonMapper.mapFrom(person))
                .build();


    }

    @Override
    public Optional<ReadPersonRoleDto> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Optional<ReadPersonRoleDto> update(Integer integer, CreateUpdatePersonRoleDto object) {
        return Optional.empty();
    }

    @Override
    public void delete(Integer integer) {

    }



    @Override
    public List<ReadPersonRoleDto> findAll() {
        return null;
    }

    public Optional<ReadPersonRoleDto> findByEmailAndPassword(String email, String password) {
//        var readPersonRoleDtoBuilder = ReadPersonRoleDto.builder();
//
//        personRepository.findByEmailAndPassword(email, password)
//                .ifPresent(person -> {
//
//                    readPersonRoleDtoBuilder.readPersonDto(readPersonMapper.mapFrom(person))
//                            .readRoleDto(personRoleRepository.findPersonRoleByPersonId(person.getId())
//                                    .stream()
//                                    .map(personRole -> readRoleMapper.mapFrom(personRole.getRole())).toList());
//
//
//                });
//
//
//        var maybePersonRole = Optional.ofNullable(readPersonRoleDtoBuilder.build());
//
//        var roles = maybePersonRole
//                .map(ReadPersonRoleDto::getReadRoleDto)
//                .stream()
//                .flatMap(Collection::stream)
//                .map(ReadRoleDto::getRole)
//                .toList();
//
//
//        if (!roles.contains(role)) {
//
//        }
        return null;
    }

    public Optional<ReadPersonRoleDto> findByRoleIdAndPersonId(Integer roleId, Integer personId) {

        return personRoleRepository.findByRoleIdAndPersonId(roleId, personId)
                .map(readPersonRoleMapper::mapFrom);
    }
}
