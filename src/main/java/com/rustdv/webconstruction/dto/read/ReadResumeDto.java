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
public class ReadResumeDto implements ReadDto{

    ReadPersonDto readPersonDto;

    String keyword;

    Integer price;

    Measurements measurement;

    Weekdays weekdays;

    LocalTime startAt;

    LocalTime endAt;

    Experience experience;

    Address address;

    Team team;

    List<ReadPhotoDto> readPhotoDtoList;

    String aboutMe;

}
