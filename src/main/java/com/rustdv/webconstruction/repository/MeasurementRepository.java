package com.rustdv.webconstruction.repository;

import com.rustdv.webconstruction.entity.Measurement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {

    Optional<Measurement> findByName(String measurement);
}
