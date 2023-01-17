package com.rustdv.webconstruction.dto.read;

import lombok.Builder;
import lombok.Setter;
import lombok.Value;

import java.util.List;

@Value
@Builder
@Setter
public class ReadPersonRoleDto implements ReadDto {

    ReadPersonDto readPersonDto;

    String rating;

}
