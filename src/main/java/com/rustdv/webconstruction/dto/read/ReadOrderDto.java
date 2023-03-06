package com.rustdv.webconstruction.dto.read;

import com.rustdv.webconstruction.entity.Address;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
@Builder
public class ReadOrderDto implements ReadDto {

    String id;

    String orderName;

    Address address;

    ReadPersonDto readPersonDto;

    String keyword;

    List<Integer> imageIdentifiers;

    String description;

    LocalDate startAt;

    LocalDate endAt;
}
