package com.rustdv.webconstruction.dto.createupdate;

import lombok.Builder;
import lombok.Value;
import org.springframework.stereotype.Component;


@Value
@Builder
public class CreateUpdateOrderResumeDto implements CreateUpdateDto {

    String orderId;

    String resumeId;

    String resumeStatus;

    String orderStatus;
}

