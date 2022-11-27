package com.rustdv.webconstruction.dto.read;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReadPersonDto {

    String email;

    String photo;

}
