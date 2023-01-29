package com.rustdv.webconstruction.integration.repository;

import com.rustdv.webconstruction.integration.IntegrationTestBase;
import com.rustdv.webconstruction.repository.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@RequiredArgsConstructor
public class MeasurementRepositoryIT extends IntegrationTestBase {

    private final MeasurementRepository measurementRepository;

    @Test
    void getMeasurementByName() {
        String measurement = "за час";

        var actualResult = measurementRepository.findByName(measurement);

        actualResult.map(measurement1 -> assertThat(measurement1.getName()).isEqualTo(measurement));

    }
}
