package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateCommentDto;
import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePersonDto;
import com.rustdv.webconstruction.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateUpdateCommentDtoMapper implements Mapper<CreateUpdateCommentDto, Comment> {

    @Override
    public Comment mapFrom(CreateUpdateCommentDto from) {

        return Comment.builder()
                .comment(from.getComment())
                .build();
    }
}
