package com.rustdv.webconstruction.service;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateResumeDto;
import com.rustdv.webconstruction.dto.read.ReadResumeDto;
import com.rustdv.webconstruction.entity.Keyword;
import com.rustdv.webconstruction.entity.Measurement;
import com.rustdv.webconstruction.entity.Resume;
import com.rustdv.webconstruction.mapping.CreateUpdateResumeMapper;
import com.rustdv.webconstruction.mapping.ReadPersonMapper;
import com.rustdv.webconstruction.mapping.ReadResumeMapper;
import com.rustdv.webconstruction.repository.KeywordRepository;
import com.rustdv.webconstruction.repository.MeasurementRepository;
import com.rustdv.webconstruction.repository.PersonRepository;
import com.rustdv.webconstruction.repository.ResumeRepository;
import com.rustdv.webconstruction.util.ImageLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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

    private final PersonRepository personRepository;


    private final ImageLoader imageLoader;

    private final ReadResumeMapper readResumeMapper;

    @Value("${app.resumes.path}")
    private final String RESUMES_IMAGES_FOLDER;


    @Transactional
    @Override
    public ReadResumeDto create(CreateUpdateResumeDto object) {

        var savedResume = resumeRepository.save(createUpdateResumeMapper.mapFrom(object));


        return readResumeMapper.mapFrom(savedResume);


    }

    @Transactional
    public ReadResumeDto create(CreateUpdateResumeDto object, Integer id) {

        var maybePerson = personRepository.findById(id);

        imageLoader.upload(object.getImages(), RESUMES_IMAGES_FOLDER);

        return maybePerson.map(person -> {

                    var resume = resumeRepository.save(createUpdateResumeMapper.mapFrom(object, person));
                    return readResumeMapper.mapFrom(resume);
                }
        ).orElse(null);

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

        return resumeRepository.findAll()
                .stream()
                .map(readResumeMapper::mapFrom)
                .toList();

    }
}
