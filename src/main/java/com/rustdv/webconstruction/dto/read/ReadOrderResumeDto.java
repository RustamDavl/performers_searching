package com.rustdv.webconstruction.dto.read;

import lombok.Builder;
import lombok.Value;
import org.springframework.stereotype.Component;


@Builder
@Value
public class ReadOrderResumeDto implements ReadDto {

    Integer id;

    ReadOrderDto readOrderDto;

    ReadResumeDto readResumeDto;

    ReadPersonDto orderWithReply;

    String resumeStatus;

    String orderStatus;
}
