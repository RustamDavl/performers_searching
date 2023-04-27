package com.rustdv.webconstruction.service;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateCommentDto;
import com.rustdv.webconstruction.dto.createupdate.CreateUpdateOrderDto;
import com.rustdv.webconstruction.dto.read.ReadCommentDto;
import com.rustdv.webconstruction.dto.read.ReadPersonDto;
import com.rustdv.webconstruction.entity.Person;
import com.rustdv.webconstruction.mapping.CreateUpdateCommentDtoMapper;
import com.rustdv.webconstruction.mapping.ReadCommentDtoMapper;
import com.rustdv.webconstruction.mapping.ReadPersonMapper;
import com.rustdv.webconstruction.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService implements IService<CreateUpdateCommentDto, ReadCommentDto, Integer> {

    private final CommentRepository commentRepository;

    private final CreateUpdateCommentDtoMapper createUpdateCommentDtoMapper;

    private final ReadCommentDtoMapper readCommentDtoMapper;

    private final PersonService personService;

    private final ReadPersonMapper readPersonMapper;


    @Override
    public ReadCommentDto create(CreateUpdateCommentDto object) {

        Optional<ReadPersonDto> recipient = personService.findById(Integer.valueOf(object.getRecipientId()));
        Optional<ReadPersonDto> sender = personService.findById(Integer.valueOf(object.getSenderId()));

        var commentToSave = createUpdateCommentDtoMapper.mapFrom(object);

        recipient.map(readPersonMapper::mapFrom)
                .ifPresent(person -> person.addReceivedComments(commentToSave));

        sender.map(readPersonMapper::mapFrom)
                .ifPresent(person -> person.addSentComments(commentToSave));

        return readCommentDtoMapper.mapFrom(commentRepository.save(commentToSave));

    }

    @Override
    public Optional<ReadCommentDto> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Optional<ReadCommentDto> update(Integer integer, CreateUpdateCommentDto object) {
        return Optional.empty();
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<ReadCommentDto> findAll() {
        return null;
    }
}
