package com.rustdv.webconstruction.dto.createupdate;


import com.rustdv.webconstruction.dto.read.ReadRoleDto;
import com.rustdv.webconstruction.validation.annotation.ValidPassword;
import com.rustdv.webconstruction.validation.annotation.ValidRole;
import com.rustdv.webconstruction.validation.group.CreateGroup;
import lombok.Builder;
import lombok.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;
import javax.validation.groups.Default;

@Value
@Builder
public class CreateUpdatePersonRoleDto implements CreateUpdateDto{

    @Size(min = 3, max = 64)
    @NotBlank
    String firstName;

    @NotEmpty
    @Email
    String email;

    @ValidPassword(groups = {Default.class, CreateGroup.class})
    String rawPassword;


    @ValidRole(groups = {Default.class, CreateGroup.class})
    String role;
}
