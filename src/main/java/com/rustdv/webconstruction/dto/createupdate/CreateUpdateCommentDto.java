package com.rustdv.webconstruction.dto.createupdate;

import com.rustdv.webconstruction.dto.read.ReadPersonDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldDefaults;


@Builder
@Value
public class CreateUpdateCommentDto implements CreateUpdateDto {

    String comment;
    CreateUpdatePersonDto recipient;
    CreateUpdatePersonDto sender;

}
