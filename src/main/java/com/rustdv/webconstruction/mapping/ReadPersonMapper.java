package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.read.ReadPersonDto;
import com.rustdv.webconstruction.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class ReadPersonMapper implements Mapper<Person, ReadPersonDto> {
    @Override
    public ReadPersonDto mapFrom(Person from) {

        return ReadPersonDto.builder()
                .id(String.valueOf(from.getId()))
                .firstName(from.getFirstName())
                .email(from.getEmail())
                .photo(from.getPhoto())
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
