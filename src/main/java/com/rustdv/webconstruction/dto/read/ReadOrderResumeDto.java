package com.rustdv.webconstruction.dto.read;

import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class ReadOrderResumeDto implements ReadDto {

    Integer id;

    ReadOrderDto readOrderDto;

    ReadResumeDto readResumeDto;

    ReadPersonDto orderWithReply;

    String resumeStatus;

    String orderStatus;

    Boolean accepted;

    Boolean submitted;

    String personId; //person's id which submitted the order
}
