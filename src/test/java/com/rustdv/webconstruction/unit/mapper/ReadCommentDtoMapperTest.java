package com.rustdv.webconstruction.unit.mapper;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePersonDto;
import com.rustdv.webconstruction.dto.read.ReadCommentDto;
import com.rustdv.webconstruction.dto.read.ReadPersonDto;
import com.rustdv.webconstruction.entity.Comment;
import com.rustdv.webconstruction.entity.Person;
import com.rustdv.webconstruction.mapping.ReadCommentDtoMapper;
import com.rustdv.webconstruction.mapping.ReadPersonMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ReadCommentDtoMapperTest {
    @Mock
    private ReadPersonMapper readPersonMapper;
    @InjectMocks
    private ReadCommentDtoMapper readCommentDtoMapper;

    @Test
    void map() {

        ReadPersonDto readRecipient = ReadPersonDto
                .builder()
                .id(String.valueOf(10))
                .firstName("Rustam")
                .email("easton12345@gmail.com")
                .photo("path")
                .personalInfo("recipient info")
                .build();
        ReadPersonDto readSender = ReadPersonDto
                .builder()
                .id(String.valueOf(11))
                .firstName("Idris")
                .email("easton12@gmail.com")
                .photo("path")
                .personalInfo("recipient info")
                .build();

        Person recipient = Person.builder()
                .id(10)
                .firstName("Rustam")
                .email("easton12345@gmail.com")
                .password("pass")
                .photo("path")
                .personalInfo("info")
                .build();
        Person sender = Person.builder()
                .id(11)
                .firstName("Idris")
                .email("easton12@gmail.com")
                .password("pass")
                .photo("sender path")
                .personalInfo("sender info")
                .build();
        var expectedResult = ReadCommentDto.builder()
                .id(15)
                .comment("hello")
                .recipient(readRecipient)
                .sender(readSender)
                .build();

        Mockito.doReturn(readRecipient).when(readPersonMapper).mapFrom(recipient);
        Mockito.doReturn(readSender).when(readPersonMapper).mapFrom(sender);

        Comment comment = Comment.builder()
                .id(15)
                .comment("hello")
                .recipient(recipient)
                .sender(sender)
                .build();

        var actualResult = readCommentDtoMapper.mapFrom(comment);

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
        Assertions.assertThat(actualResult.getRecipient()).isEqualTo(expectedResult.getRecipient());
        Assertions.assertThat(actualResult.getSender()).isEqualTo(expectedResult.getSender());


    }
}
