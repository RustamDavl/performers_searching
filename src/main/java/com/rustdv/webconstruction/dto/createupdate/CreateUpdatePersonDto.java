package com.rustdv.webconstruction.dto.createupdate;

import com.rustdv.webconstruction.entity.Roles;
import com.rustdv.webconstruction.validation.annotation.ValidPassword;
import com.rustdv.webconstruction.validation.annotation.ValidRole;
import com.rustdv.webconstruction.validation.group.CreateGroup;
import lombok.Builder;
import lombok.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.util.Objects;
import java.util.stream.Stream;

@Value
@Builder
public class CreateUpdatePersonDto implements CreateUpdateDto {


    @Size(min = 3, max = 64)
    @NotBlank
    String firstName;

    @NotEmpty
    @Email
    String email;

    @ValidPassword(groups = {Default.class, CreateGroup.class})
    String rawPassword;

    String photo;

    MultipartFile multipartFile;

    @ValidRole(groups = {Default.class, CreateGroup.class})
    String role;

    String personalInfo;

    public boolean fieldsNull() {
        if(multipartFile == null) {
            return Stream.of(firstName, email, rawPassword, photo, role, personalInfo)
                    .allMatch(Objects::isNull);
        }
        return Stream.of(firstName, email, rawPassword, photo, role, personalInfo)
                .allMatch(Objects::isNull) && multipartFile.isEmpty();
    }

}
