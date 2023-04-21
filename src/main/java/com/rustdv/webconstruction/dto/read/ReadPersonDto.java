package com.rustdv.webconstruction.dto.read;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class ReadPersonDto implements ReadDto {

    String id;

    String firstName;

    String email;

    String photo;

    List<ReadResumeDto> readResumeDtos;

    ReadOrderDto readOrderDto;

    String rating;

    String personalInfo;

}
