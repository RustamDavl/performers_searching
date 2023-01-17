package com.rustdv.webconstruction.dto.read;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReadKeywordDto implements ReadDto{

    Integer id;

    String keyword;

}
