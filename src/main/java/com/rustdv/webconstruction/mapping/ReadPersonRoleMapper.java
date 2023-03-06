package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.read.ReadPersonRoleDto;
import com.rustdv.webconstruction.entity.PersonRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReadPersonRoleMapper implements Mapper<PersonRole, ReadPersonRoleDto> {

    private final ReadPersonMapper readPersonMapper;

    private final ReadRoleMapper readRoleMapper;


    @Override
    public ReadPersonRoleDto mapFrom(PersonRole from) {

        return ReadPersonRoleDto.builder()
                .readPersonDto(readPersonMapper.mapFrom(from.getPerson()))
                .rating(String.valueOf(from.getRating()))
                .build();
    }
}
