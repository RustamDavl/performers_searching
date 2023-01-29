package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.read.ReadResumeDto;
import com.rustdv.webconstruction.entity.PhotoForResume;
import com.rustdv.webconstruction.entity.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReadResumeMapper implements Mapper<Resume, ReadResumeDto> {

    private final ReadPersonMapper readPersonMapper;

    @Override
    public ReadResumeDto mapFrom(Resume from) {

        return ReadResumeDto.builder()
                .id(from.getId())
                .readPersonDto(readPersonMapper.mapFrom(from.getPerson()))
                .keyword(from.getKeyword().getName())
                .measurement(from.getMeasurement().getName())
                .price(from.getPrice())
                .weekdays(from.getWeekdays())
                .startAt(from.getStartAt())
                .endAt(from.getEndAt())
                .experience(from.getExperience().getValue())
                .address(from.getAddress())
                .imagePaths(from.getResumeImages().stream()
                        .map(PhotoForResume::getImage)
                        .toList())
                .team(from.getTeam().getDescription())
                .aboutMe(from.getAboutMe())
                .build();


    }
}
