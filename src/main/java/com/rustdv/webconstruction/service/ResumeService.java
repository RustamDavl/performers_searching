package com.rustdv.webconstruction.service;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateResumeDto;
import com.rustdv.webconstruction.dto.read.ReadResumeDto;
import com.rustdv.webconstruction.mapping.CreateUpdateResumeMapper;
import com.rustdv.webconstruction.mapping.ReadPersonMapper;
import com.rustdv.webconstruction.repository.ResumeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ResumeService implements IService<CreateUpdateResumeDto, ReadResumeDto, Integer> {


    private final ResumeRepository resumeRepository;

    private final ReadPersonMapper readPersonMapper;

    private final CreateUpdateResumeMapper createUpdateResumeMapper;


    @Transactional
    @Override
    public ReadResumeDto create(CreateUpdateResumeDto object) {

        var savedResume =  resumeRepository.save(createUpdateResumeMapper.mapFrom(object));


        return ReadResumeDto.builder()
                .readPersonDto(readPersonMapper.mapFrom(savedResume.getPerson()))
                .keyword(savedResume.getKeyword().getKeyword())
                .price(savedResume.getPrice())
                .measurement(savedResume.getMeasurement().getMeasurement())
                .weekdays(savedResume.getWeekdays())
                .startAt(savedResume.getStartAt())
                .endAt(savedResume.getEndAt())
                .experience(savedResume.getExperience())
                .address(savedResume.getAddress())
                .team(savedResume.getTeam())
                .readPhotoDtoList(null)
                .aboutMe(savedResume.getAboutMe())
                .build();





    }



    @Override
    public Optional<ReadResumeDto> findById(Integer integer) {
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<ReadResumeDto> update(Integer integer, CreateUpdateResumeDto object) {
        return Optional.empty();
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<ReadResumeDto> findAll() {
        return null;
    }
}
