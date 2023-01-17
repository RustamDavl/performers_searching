package com.rustdv.webconstruction.dto.read;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReadRoleDto implements ReadDto{

    Integer id;

    String role;


}
