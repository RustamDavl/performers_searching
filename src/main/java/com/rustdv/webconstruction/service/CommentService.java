package com.rustdv.webconstruction.service;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateCommentDto;
import com.rustdv.webconstruction.dto.createupdate.CreateUpdateOrderDto;
import com.rustdv.webconstruction.dto.read.ReadCommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService implements IService<CreateUpdateCommentDto, ReadCommentDto, Integer> {


    @Override
    public ReadCommentDto create(CreateUpdateCommentDto object) {
        return null;
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
