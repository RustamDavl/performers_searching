package com.rustdv.webconstruction.repository;

import com.rustdv.webconstruction.entity.Role;
import com.rustdv.webconstruction.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRole(Roles role);

    List<Role> findAll();
}
