package com.rustdv.webconstruction.dto.createupdate;

import com.rustdv.webconstruction.validation.annotation.ValidPassword;
import com.rustdv.webconstruction.validation.annotation.ValidRole;
import com.rustdv.webconstruction.validation.group.CreateGroup;
import com.rustdv.webconstruction.validation.group.ReadUpdateGroup;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.groups.Default;

@Value
@Builder
public class PersonLoginDto implements CreateUpdateDto {

    @NotBlank
    String email;

    @NotBlank
    String rawPassword;

    @ValidRole(groups = {Default.class, ReadUpdateGroup.class})
    @NotBlank
    String role;


}
