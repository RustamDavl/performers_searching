package com.rustdv.webconstruction.dto.createupdate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUpdateRoleDto implements CreateUpdateDto{

    String role;
}
