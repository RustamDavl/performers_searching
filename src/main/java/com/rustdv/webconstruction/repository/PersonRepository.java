package com.rustdv.webconstruction.repository;

import com.rustdv.webconstruction.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {


     Optional<Person> findByEmailAndPassword(String email, String password);

}
