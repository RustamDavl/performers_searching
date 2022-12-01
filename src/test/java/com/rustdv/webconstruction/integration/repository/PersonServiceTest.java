package com.rustdv.webconstruction.integration.repository;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePersonDto;
import com.rustdv.webconstruction.dto.read.ReadPersonDto;
import com.rustdv.webconstruction.entity.Person;
import com.rustdv.webconstruction.integration.IntegrationTestBase;
import com.rustdv.webconstruction.repository.PersonRepository;
import com.rustdv.webconstruction.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@RequiredArgsConstructor
public class PersonServiceTest extends IntegrationTestBase {

    private static final Integer PERSON_ID = 10;
    private final PersonService personService;

    @Test
    void findAll() {
        var people = personService.findAll();

        assertThat(people).hasSize(20);
    }

    @Test
    void getPersonById() {

        var expectedPerson = ReadPersonDto.builder()
                .id(String.valueOf(PERSON_ID))
                .firstName("Tanisha")
                .email("ue@nuncsed.ca")
                .photo("C:/Desktop/someFolder")
                .build();

        var actualPerson = personService.findById(PERSON_ID);

        actualPerson.ifPresent(person1 -> assertThat(person1).isEqualTo(expectedPerson));


    }

    @Test
    void createPerson() {

        var createUpdatePersonDto = CreateUpdatePersonDto.builder()
                .firstName("Idris")
                .email("easton1234537@gmail.com")
                .rawPassword("verystrongpassword")
                .photo("C:/Desktop/someFolder")
                .build();

        var readPersonDto = personService.create(createUpdatePersonDto);

        assertThat(readPersonDto.getFirstName()).isEqualTo(createUpdatePersonDto.getFirstName());
        assertThat(readPersonDto.getEmail()).isEqualTo(createUpdatePersonDto.getEmail());


    }

    @Test
    void updatePerson() {

        var createUpdatePersonDto = CreateUpdatePersonDto.builder()
                .firstName("Idris2")
                .email("easton113344@gmail.com")
                .rawPassword("verystrongpassword")
                .photo("C:/Desktop/someFolder")
                .build();

        personService.update(PERSON_ID, createUpdatePersonDto);

        var actualPerson = personService.findById(PERSON_ID);

        actualPerson.ifPresent(readPersonDto -> assertThat(readPersonDto.getEmail()).isEqualTo(createUpdatePersonDto.getEmail()));
        actualPerson.ifPresent(readPersonDto -> assertThat(readPersonDto.getFirstName()).isEqualTo(createUpdatePersonDto.getFirstName()));

    }



    @Test
    void deletePerson() {
        personService.delete(PERSON_ID);

        var nullPerson = personService.findById(PERSON_ID);

        assertThat(nullPerson).isEmpty();
    }

    @Test
    void findByEmailAndPassword() {
        var result = personService.findByEmailAndPassword("neque.Nullam@ut.org","pede.");

        result.ifPresent(readPersonDto -> assertThat(readPersonDto.getId()).isEqualTo("1"));
        result.ifPresent(readPersonDto -> assertThat(readPersonDto.getFirstName()).isEqualTo("Vera"));
    }
}
