package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.createupdate.CreatePersonDto;
import com.rustdv.webconstruction.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class CreatePersonMapper implements Mapper<CreatePersonDto, Person>{
    @Override
    public Person mapFrom(CreatePersonDto from) {
        return Person.builder()
                .email(from.getEmail())
                .password(from.getRawPassword())
                .build();
    }
}
