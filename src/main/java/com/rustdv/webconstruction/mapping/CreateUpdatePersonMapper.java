package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePersonDto;
import com.rustdv.webconstruction.entity.Person;
import com.rustdv.webconstruction.util.ImageLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUpdatePersonMapper implements Mapper<CreateUpdatePersonDto, Person> {

    private final ImageLoader imageLoader;

    @Override
    public Person mapFrom(CreateUpdatePersonDto from) {
        return Person.builder()
                .firstName(from.getFirstName())
                .email(from.getEmail())
                .password(from.getRawPassword())
                .build();
    }

    @Override
    public Person update(CreateUpdatePersonDto from, Person to) {
        if (from.getFirstName() != null) {
            to.setFirstName(from.getFirstName());
        }

        if (from.getEmail() != null) {
            to.setEmail(from.getEmail());
        }
        var multipartFile = from.getMultipartFile();
        if (multipartFile != null) {
            var originalFileName = imageLoader.updatePersonIcon(multipartFile);
            to.setPhoto(originalFileName);
        }
        if (from.getPhoto() != null) {
            to.setPhoto(from.getPhoto());
        }
        if (from.getPersonalInfo() != null) {
            to.setPersonalInfo(from.getPersonalInfo());
        }

        return to;
    }
}
