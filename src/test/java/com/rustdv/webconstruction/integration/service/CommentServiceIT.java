package com.rustdv.webconstruction.integration.service;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateCommentDto;
import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePersonDto;
import com.rustdv.webconstruction.dto.read.ReadCommentDto;
import com.rustdv.webconstruction.entity.Person;
import com.rustdv.webconstruction.integration.IntegrationTestBase;
import com.rustdv.webconstruction.mapping.CreateUpdatePersonMapper;
import com.rustdv.webconstruction.mapping.ReadPersonMapper;
import com.rustdv.webconstruction.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class CommentServiceIT extends IntegrationTestBase {

    private final CommentService commentService;

    private final ReadPersonMapper readPersonMapper;

    private final CreateUpdatePersonMapper createUpdatePersonMapper;

    @Test
    void create() {

        CreateUpdateCommentDto createUpdateCommentDto = CreateUpdateCommentDto.builder()
                .comment("very well and very good!")
                .recipientId("10")
                .senderId("5")
                .build();

        ReadCommentDto savedComment = commentService.create(createUpdateCommentDto);

        assertThat(savedComment).isNotNull();
        assertThat(savedComment.getRecipient().getId()).isEqualTo(createUpdateCommentDto.getRecipientId());
        assertThat(savedComment.getSender().getId()).isEqualTo(createUpdateCommentDto.getSenderId());
        assertThat(savedComment.getComment()).isEqualTo(createUpdateCommentDto.getComment());


    }
}
