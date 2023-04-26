package com.rustdv.webconstruction.unit.mapper;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateCommentDto;
import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePersonDto;
import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePhotoDto;
import com.rustdv.webconstruction.entity.Comment;
import com.rustdv.webconstruction.entity.Person;
import com.rustdv.webconstruction.mapping.CreateUpdateCommentDtoMapper;
import com.rustdv.webconstruction.mapping.CreateUpdatePersonMapper;
import com.rustdv.webconstruction.util.ImageLoader;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
public class CreateUpdateCommentDtoMapperTest {

    @Mock
    private CreateUpdatePersonMapper createUpdatePersonMapper;
    @InjectMocks
    private CreateUpdateCommentDtoMapper createUpdateCommentDtoMapper;

    @Test
    public void map() {

        CreateUpdatePersonDto createUpdatePerson1Dto = CreateUpdatePersonDto
                .builder()
                .firstName("Rustam")
                .email("easton12345@gmail.com")
                .rawPassword("pass")
                .photo("path")
                .personalInfo("info")
                .build();

        CreateUpdatePersonDto createUpdatePerson2Dto = CreateUpdatePersonDto
                .builder()
                .firstName("Idris")
                .email("easton12@gmail.com")
                .rawPassword("pass")
                .photo("path")
                .personalInfo("info")
                .build();

        Person recipient = Person.builder()
                .firstName("Rustam")
                .email("easton12345@gmail.com")
                .password("pass")
                .photo("path")
                .personalInfo("info")
                .build();
        Person sender = Person.builder()
                .firstName("Idris")
                .email("easton12@gmail.com")
                .password("pass")
                .photo("path")
                .personalInfo("info")
                .build();
        var expectedResult = Comment.builder()
                .id(10)
                .comment("test comment")
                .recipient(recipient)
                .sender(sender)
                .build();

        Mockito.doReturn(recipient).when(createUpdatePersonMapper).mapFrom(createUpdatePerson1Dto);
        Mockito.doReturn(sender).when(createUpdatePersonMapper).mapFrom(createUpdatePerson2Dto);


        CreateUpdateCommentDto createUpdateCommentDto = CreateUpdateCommentDto.builder()
                .comment("test comment")
                .recipient(createUpdatePerson1Dto)
                .sender(createUpdatePerson2Dto)
                .build();

        var actualResult = createUpdateCommentDtoMapper.mapFrom(createUpdateCommentDto);
        actualResult.setId(10);

        Assertions.assertThat(actualResult.getSender()).isEqualTo(sender);
        Assertions.assertThat(actualResult.getRecipient()).isEqualTo(recipient);
        Assertions.assertThat(actualResult).isEqualTo(expectedResult);


    }

}
