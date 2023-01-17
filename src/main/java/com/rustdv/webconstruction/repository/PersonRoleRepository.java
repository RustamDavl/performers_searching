package com.rustdv.webconstruction.repository;

import com.rustdv.webconstruction.entity.PersonRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRoleRepository extends JpaRepository<PersonRole, Integer> {


    List<PersonRole> findPersonRoleByPersonId(Integer id);


}
