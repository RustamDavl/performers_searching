package com.rustdv.webconstruction.dto.createupdate;

import com.rustdv.webconstruction.dto.read.ReadKeywordDto;
import com.rustdv.webconstruction.dto.read.ReadPersonDto;
import com.rustdv.webconstruction.entity.*;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Value
@Builder
public class CreateUpdateResumeDto implements CreateUpdateDto {

    Integer personId;

    String keyword;

    Integer price;

    Measurements measurement;

    Weekdays weekdays;

    LocalTime startAt;

    LocalTime endAt;

    Experience experience;

    Address address;

    Team team;

    @Builder.Default
    List<CreateUpdatePhotoDto> createUpdatePhotoDtoList = new ArrayList<>();

    String aboutMe;


}
