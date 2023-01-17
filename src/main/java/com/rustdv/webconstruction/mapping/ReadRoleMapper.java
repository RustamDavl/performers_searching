package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.read.ReadRoleDto;
import com.rustdv.webconstruction.entity.Role;
import com.rustdv.webconstruction.entity.Roles;
import org.springframework.stereotype.Component;

@Component
public class ReadRoleMapper implements Mapper<Role, ReadRoleDto> {
    @Override
    public ReadRoleDto mapFrom(Role from) {
        return ReadRoleDto.builder()
                .id(from.getId())
                .role(from.getRole().getName())
                .build();
    }

    public Role mapFrom(ReadRoleDto readRoleDto) {
        return Role.builder()
                .id(readRoleDto.getId())
                .role(Roles.getEnumByName(readRoleDto.getRole()))
                .build();
    }
}
