package com.rustdv.webconstruction.dto.createupdate;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
public class CreateUpdatePhotoDto implements CreateUpdateDto {

    String bytes;
}
