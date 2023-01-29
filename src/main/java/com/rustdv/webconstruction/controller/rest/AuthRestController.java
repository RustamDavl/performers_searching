package com.rustdv.webconstruction.controller.rest;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePersonDto;
import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePersonRoleDto;
import com.rustdv.webconstruction.dto.createupdate.PersonLoginDto;
import com.rustdv.webconstruction.dto.read.ReadPersonDto;
import com.rustdv.webconstruction.dto.read.ReadPersonRoleDto;
import com.rustdv.webconstruction.dto.read.ReadRoleDto;
import com.rustdv.webconstruction.entity.Roles;
import com.rustdv.webconstruction.service.PersonRoleService;
import com.rustdv.webconstruction.service.PersonService;
import com.rustdv.webconstruction.validation.group.CreateGroup;
import com.rustdv.webconstruction.validation.group.ReadUpdateGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthRestController {

    private final PersonService personService;

    private final PersonRoleService personRoleService;

    @PostMapping("/signup")
    public ResponseEntity<ReadPersonRoleDto> signUp(@RequestBody
                                                    @Validated({Default.class, CreateGroup.class})
                                                    CreateUpdatePersonRoleDto createUpdatePersonRoleDto) {

        var maybePerson = personService.findByEmail(createUpdatePersonRoleDto.getEmail());


        return maybePerson.map(readPersonDto -> ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(ReadPersonRoleDto
                                .builder()
                                .readPersonDto(readPersonDto)
                                .build()))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(personRoleService.create(createUpdatePersonRoleDto)));

    }

    @PostMapping("/signin")
    public ResponseEntity<ReadPersonDto> signIn(@RequestBody @Validated({Default.class, ReadUpdateGroup.class})
                                                PersonLoginDto personLoginDto) {


        var maybePersonDto = personService.findByEmailAndPassword(
                personLoginDto.getEmail(),
                personLoginDto.getRawPassword()
        );


        return maybePersonDto.map(readPersonDto -> ResponseEntity.status(HttpStatus.OK)
                        .body(maybePersonDto.get()))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .body(ReadPersonDto.builder().build()));


    }
}
