package com.rustdv.webconstruction.service;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateResumeDto;
import com.rustdv.webconstruction.dto.read.ReadOrderResumeDto;
import com.rustdv.webconstruction.dto.read.ReadResumeDto;
import com.rustdv.webconstruction.entity.*;
import com.rustdv.webconstruction.mapping.CreateUpdateResumeMapper;
import com.rustdv.webconstruction.mapping.ReadPersonMapper;
import com.rustdv.webconstruction.mapping.ReadResumeMapper;
import com.rustdv.webconstruction.repository.PersonRepository;
import com.rustdv.webconstruction.repository.ResumeRepository;
import com.rustdv.webconstruction.util.ImageLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        imageLoader.uploadAllImages(object.getImages(), RESUMES_IMAGES_FOLDER);

        return maybePerson.map(person -> {

                    var resume = resumeRepository.save(createUpdateResumeMapper.mapFrom(object, person));
                    return readResumeMapper.mapFrom(resume);
                }
        ).orElse(null);

    }

    public byte[] getImageByResumeIdAndImageId(Integer resumeId, Integer imageId) {

        var image = resumeRepository.findById(resumeId)
                .stream()
                .map(Resume::getResumeImages)
                .flatMap(Collection::stream)
                .filter(photoForResume -> photoForResume.getId().equals(imageId))
                .map(PhotoForResume::getImage)
                .filter(StringUtils::hasText)
                .collect(Collectors.joining());

        return imageLoader.downloadOneImage(image, RESUMES_IMAGES_FOLDER);
    }

    @Override
    public Optional<ReadResumeDto> findById(Integer id) {
        return resumeRepository.findById(id)
                .map(readResumeMapper::mapFrom);
    }

    @Transactional
    @Override
    public Optional<ReadResumeDto> update(Integer integer, CreateUpdateResumeDto object) {
        return Optional.empty();
    }

    @Override
    public void delete(Integer resumeId) {

        resumeRepository.findById(resumeId)
                .ifPresent(resume -> {
                    resumeRepository.delete(resume);
                    resumeRepository.flush();
                });
    }

    @Override
    public List<ReadResumeDto> findAll() {

        return resumeRepository.findAll()
                .stream()
                .map(readResumeMapper::mapFrom)
                .toList();

    }

    public List<ReadResumeDto> findAllByPersonId(Integer id) {
        return resumeRepository.findAllByPersonId(id)
                .stream()
                .map(readResumeMapper::mapFrom)
                .toList();
    }

    public Optional<ReadResumeDto> findResumeByPersonId(Integer personId) {

        return resumeRepository.findResumeByPersonId(personId)
                .map(readResumeMapper::mapFrom);
    }

    public List<ReadResumeDto> findRespondedResumesByCustomerId(Integer id) {

        return personRepository.findById(id)
                .stream()
                .map(Person::getOrders)
                .flatMap(Collection::stream)
                .map(Order::getOrdersResumeList)
                .flatMap(Collection::stream)
                .map(OrdersResume::getResume)
                .map(readResumeMapper::mapFrom)
                .toList();

    }
}
