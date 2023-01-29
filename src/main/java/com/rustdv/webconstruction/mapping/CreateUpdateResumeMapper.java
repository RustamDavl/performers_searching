package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateResumeDto;
import com.rustdv.webconstruction.entity.*;
import com.rustdv.webconstruction.repository.*;
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

    private final ExperienceRepository experienceRepository;

    private final CreateUpdatePhotoMapper createUpdatePhotoMapper;


    @Override
    public Resume mapFrom(CreateUpdateResumeDto from) {

//        return Resume.builder()
//                .person(findPersonById(from.get)
//                .keyword(findKeywordByName(from.getKeyword()).orElseThrow())
//                .measurement(findMeasurementByName(from.getMeasurement()).orElseThrow())
//                .price(from.getPrice())
//                .weekdays(from.getWeekdays())
//                .startAt(from.getStartAt())
//                .endAt(from.getEndAt())
//                .experience(from.getExperience())
//                .address(from.getAddress())
//                .resumePhotos(resumePhotos)
//                .aboutMe(from.getAboutMe())
//                .team(from.getTeam())
//                .build();

        return null;

    }

    public Resume mapFrom(CreateUpdateResumeDto from, Person person) {

        var resume = Resume.builder()
                .person(person)
                .keyword(keywordRepository.findByName(from.getKeyword()).orElse(null))
                .measurement(measurementRepository.findByName(from.getMeasurement()).orElse(null))
                .price(Integer.valueOf(from.getPrice()))
                .weekdays(new Weekdays(from.getMon(), from.getTues(), from.getWed(), from.getThurs(),
                        from.getFri(), from.getSat(), from.getSun()))
                .startAt(from.getStartAt())
                .endAt(from.getEndAt())
                .experience(experienceRepository.findByValue(from.getExperience()).orElse(null))
                .address(new Address(from.getCity(), from.getStreet(), from.getHouseNumber()))
                .team(Team.getEnumByName(from.getTeam()))
                .aboutMe(from.getAboutMe())
                .build();

        var imageNames = from.getImages().stream()
                .map(multipartFile -> PhotoForResume.builder()
                        .image(multipartFile.getOriginalFilename())
                        .build())
                .toList();

        resume.addPhotos(imageNames);

        return resume;
    }


}
