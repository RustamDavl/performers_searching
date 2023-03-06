package com.rustdv.webconstruction.dto.read;

import com.rustdv.webconstruction.entity.*;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalTime;
import java.util.List;

@Value
@Builder
@RequiredArgsConstructor
public class ReadResumeDto implements ReadDto {

    Integer id;

    ReadPersonDto readPersonDto;

    String keyword;

    Integer price;

    String measurement;

    String weekdays;

    LocalTime startAt;

    LocalTime endAt;

    String experience;

    Address address;

    String team;

    List<Integer> imageIdentifiers;

    String aboutMe;



}
