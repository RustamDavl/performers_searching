package com.rustdv.webconstruction.dto.createupdate;

import com.rustdv.webconstruction.entity.*;
import lombok.Builder;
import lombok.Value;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalTime;
import java.util.List;

@Value
@Builder
public class CreateUpdateResumeDto implements CreateUpdateDto {

    String keyword;

    String team;

    String price;

    String measurement;

    Boolean mon;

    Boolean tues;

    Boolean wed;

    Boolean thurs;

    Boolean fri;

    Boolean sat;

    Boolean sun;

    LocalTime startAt;

    LocalTime endAt;

    String experience;

    String city;

    String street;

    String houseNumber;

    List<MultipartFile> images;

    String aboutMe;


}
