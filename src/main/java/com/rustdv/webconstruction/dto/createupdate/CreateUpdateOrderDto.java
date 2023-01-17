package com.rustdv.webconstruction.dto.createupdate;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Value
@Builder
public class CreateUpdateOrderDto implements CreateUpdateDto {

    String orderName;

    String keyword;

    String city;

    String street;

    String houseNumber;

    List<MultipartFile> images;

    LocalDate startAt;

    LocalDate endAt;

    String description;



}
