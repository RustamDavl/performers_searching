package com.rustdv.webconstruction.repository;

import com.rustdv.webconstruction.entity.PersonRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRoleRepository extends JpaRepository<PersonRole, Integer> {


    List<PersonRole> findPersonRoleByPersonId(Integer id);

    Optional<PersonRole> findByRoleIdAndPersonId(Integer roleId, Integer personId);



}
