package com.rustdv.webconstruction.unit.mapper;

import com.rustdv.webconstruction.mapping.ReadDateDtoMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ReadDateMapperTest {


    @Test
    void checkReadDateDto() {
        var startAt = LocalDate.of(2023, 3, 27);
        var endAt = LocalDate.now();

        ReadDateDtoMapper readDateDtoMapper = new ReadDateDtoMapper();
        var result = readDateDtoMapper.mapFrom(startAt, endAt);

        System.out.println(result);


    }
}
