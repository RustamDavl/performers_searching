package com.rustdv.webconstruction.dto.read;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReadDateDto {

    String startAtDay;
    String startAtMonth;
    String endAtDay;
    String endAtMonth;


}
