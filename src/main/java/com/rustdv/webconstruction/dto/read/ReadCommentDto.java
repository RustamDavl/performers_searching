package com.rustdv.webconstruction.dto.read;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldDefaults;

@Value
@Builder
public class ReadCommentDto implements ReadDto{

    Integer id;
    String comment;
    ReadPersonDto recipient;
    ReadPersonDto sender;
}
