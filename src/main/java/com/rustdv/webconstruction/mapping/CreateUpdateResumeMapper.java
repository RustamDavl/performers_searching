package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateResumeDto;
import com.rustdv.webconstruction.entity.*;
import com.rustdv.webconstruction.repository.KeywordRepository;
import com.rustdv.webconstruction.repository.MeasurementRepository;
import com.rustdv.webconstruction.repository.PersonRepository;
import com.rustdv.webconstruction.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CreateUpdateResumeMapper implements Mapper<CreateUpdateResumeDto, Resume> {

    private final ReadPersonMapper readPersonMapper;

    private final KeywordRepository keywordRepository;

    private final PersonRepository personRepository;

    private final MeasurementRepository measurementRepository;

    private final CreateUpdatePhotoMapper createUpdatePhotoMapper;

    @Override
    public Resume mapFrom(CreateUpdateResumeDto from) {

        var resumePhotos = from.getCreateUpdatePhotoDtoList()
                .stream()
                .map(createUpdatePhotoMapper::mapFrom)
                .toList();
        return Resume.builder()
                .person(findPersonById(from.getPersonId()).orElseThrow())
                .keyword(findKeywordByName(from.getKeyword()).orElseThrow())
                .measurement(findMeasurementByName(from.getMeasurement()).orElseThrow())
                .price(from.getPrice())
                .weekdays(from.getWeekdays())
                .startAt(from.getStartAt())
                .endAt(from.getEndAt())
                .experience(from.getExperience())
                .address(from.getAddress())
                .resumePhotos(resumePhotos)
                .aboutMe(from.getAboutMe())
                .team(from.getTeam())
                .build();


    }

    private Optional<Person> findPersonById(Integer id) {

        return personRepository.findById(id);
    }

    private Optional<Keyword> findKeywordByName(String keyword) {
        return keywordRepository.findByKeyword(keyword);
    }

    private Optional<Measurement> findMeasurementByName(Measurements measurement) {
        return measurementRepository.findByMeasurement(measurement);
    }
}
