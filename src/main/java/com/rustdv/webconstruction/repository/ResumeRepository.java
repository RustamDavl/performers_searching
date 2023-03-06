package com.rustdv.webconstruction.repository;

import com.rustdv.webconstruction.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Integer> {

    List<Resume> findAllByPersonId(Integer id);

    Optional<Resume> findResumeByPersonId(Integer id);
}
