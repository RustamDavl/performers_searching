package com.rustdv.webconstruction.dto.createupdate;

import com.rustdv.webconstruction.entity.Roles;
import com.rustdv.webconstruction.validation.annotation.ValidPassword;
import com.rustdv.webconstruction.validation.annotation.ValidRole;
import com.rustdv.webconstruction.validation.group.CreateGroup;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.*;
import javax.validation.groups.Default;

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

     @ValidRole(groups = {Default.class, CreateGroup.class})
     String role;

}
