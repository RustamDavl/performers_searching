package com.rustdv.webconstruction.dto.createupdate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUpdatePersonDto implements CreateUpdateDto {

     String firstName;

     String email;

     String rawPassword;

     String photo;

}
