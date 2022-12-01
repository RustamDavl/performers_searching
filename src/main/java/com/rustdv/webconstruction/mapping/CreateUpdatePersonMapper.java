package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePersonDto;
import com.rustdv.webconstruction.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class CreateUpdatePersonMapper implements Mapper<CreateUpdatePersonDto, Person>{
    @Override
    public Person mapFrom(CreateUpdatePersonDto from) {
        return Person.builder()
                .firstName(from.getFirstName())
                .email(from.getEmail())
                .password(from.getRawPassword())
                .build();
    }

    @Override
    public Person change(CreateUpdatePersonDto from, Person to) {
        to.setFirstName(from.getFirstName());
        to.setEmail(from.getEmail());
        to.setPhoto(from.getPhoto());
        return to;
    }
}
