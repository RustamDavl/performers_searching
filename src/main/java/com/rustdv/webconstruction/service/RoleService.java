package com.rustdv.webconstruction.service;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateRoleDto;
import com.rustdv.webconstruction.dto.read.ReadRoleDto;
import com.rustdv.webconstruction.entity.Roles;
import com.rustdv.webconstruction.mapping.ReadRoleMapper;
import com.rustdv.webconstruction.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService implements IService<CreateUpdateRoleDto, ReadRoleDto, Integer> {

    private final RoleRepository roleRepository;

    private final ReadRoleMapper readRoleMapper;

    @Override
    public ReadRoleDto create(CreateUpdateRoleDto object) {
        return null;
    }

    @Override
    public Optional<ReadRoleDto> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Optional<ReadRoleDto> update(Integer integer, CreateUpdateRoleDto object) {
        return Optional.empty();
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<ReadRoleDto> findAll() {

        return roleRepository.findAll()
                .stream()
                .map(readRoleMapper::mapFrom)
                .toList();
    }

    public Optional<ReadRoleDto> findByName(Roles role) {

        return roleRepository.findByRole(role)
                .map(readRoleMapper::mapFrom);

    }
}
