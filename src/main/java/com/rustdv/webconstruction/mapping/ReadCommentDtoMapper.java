package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.read.ReadCommentDto;
import com.rustdv.webconstruction.entity.Comment;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReadCommentDtoMapper implements Mapper<Comment, ReadCommentDto> {

    private final ReadPersonMapper readPersonMapper;

    @Override
    public ReadCommentDto mapFrom(Comment from) {
        return ReadCommentDto.builder()
                .id(from.getId())
                .comment(from.getComment())
                .recipient(readPersonMapper.mapFrom(from.getRecipient()))
                .sender(readPersonMapper.mapFrom(from.getSender()))
                .build();
    }
}
