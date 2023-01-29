package com.rustdv.webconstruction.integration.service;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePersonRoleDto;
import com.rustdv.webconstruction.dto.read.ReadPersonRoleDto;
import com.rustdv.webconstruction.integration.IntegrationTestBase;
import com.rustdv.webconstruction.mapping.CreateUpdatePersonMapper;
import com.rustdv.webconstruction.service.PersonRoleService;
import com.rustdv.webconstruction.service.PersonService;
import com.rustdv.webconstruction.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class PersonRoleServiceIT extends IntegrationTestBase {

    private final PersonRoleService personRoleService;

    private final PersonService personService;

    private final CreateUpdatePersonMapper createUpdatePersonMapper;

    private final RoleService roleService;

    @Test
    void savePersonAndRole() {

        CreateUpdatePersonRoleDto createUpdatePersonRoleDto = CreateUpdatePersonRoleDto.builder()
                .firstName("Idris")
                .email("easton1234537@gmail.com")
                .rawPassword("qwertyasdfg")
                .role("Специалист")
                .build();
        ReadPersonRoleDto readPersonRoleDto = personRoleService.create(createUpdatePersonRoleDto);



        assertThat(readPersonRoleDto.getReadPersonDto().getFirstName()).isEqualTo("Idris");
        assertThat(readPersonRoleDto.getReadPersonDto().getEmail()).isEqualTo("easton1234537@gmail.com");





    }

}
