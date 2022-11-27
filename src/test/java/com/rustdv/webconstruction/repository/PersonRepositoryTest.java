package com.rustdv.webconstruction.repository;

import com.rustdv.webconstruction.integration.IntegrationTestBase;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@RequiredArgsConstructor
public class PersonRepositoryTest extends IntegrationTestBase {


    private final PersonRepository personRepository;

    @Test
    void getPersonById() {

        var person = personRepository.findById(2);

        person.ifPresent(person1 -> assertThat(person1.getEmail()).isEqualTo("lacinia@velite.uk"));



    }
}
