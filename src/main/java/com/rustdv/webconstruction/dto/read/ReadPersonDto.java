package com.rustdv.webconstruction.dto.read;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReadPersonDto implements ReadDto {

    String firstName;

    String id;

    String email;

    String photo;

}
