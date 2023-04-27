package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.read.ReadPersonDto;
import com.rustdv.webconstruction.entity.Person;
import com.rustdv.webconstruction.repository.PersonRoleRepository;
import com.rustdv.webconstruction.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReadPersonMapper implements Mapper<Person, ReadPersonDto> {


    @Override
    public ReadPersonDto mapFrom(Person from) {

        if (from == null)
            return null;

        return ReadPersonDto.builder()
                .id(String.valueOf(from.getId()))
                .firstName(from.getFirstName())
                .email(from.getEmail())
                .photo(from.getPhoto())
                .personalInfo(from.getPersonalInfo())
                .build();
    }

    public Person mapFrom(ReadPersonDto from) {
        return Person.builder()
                .id(Integer.valueOf(from.getId()))
                .firstName(from.getFirstName())
                .email(from.getEmail())
                .photo(from.getPhoto())
                .build();
    }
}
