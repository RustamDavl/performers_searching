package com.rustdv.webconstruction.repository;

import com.rustdv.webconstruction.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer>  {

    Optional<Experience> findByValue(String name);

}
