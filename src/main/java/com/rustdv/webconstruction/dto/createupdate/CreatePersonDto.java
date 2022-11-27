package com.rustdv.webconstruction.dto.createupdate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreatePersonDto {

     String email;

     String rawPassword;

}
