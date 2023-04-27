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

public class CreateUpdateCommentDtoMapperTest {

    private CreateUpdateCommentDtoMapper createUpdateCommentDtoMapper;

    @BeforeEach
    void setUp() {
        createUpdateCommentDtoMapper = new CreateUpdateCommentDtoMapper();
    }
    @Test
    public void map() {


        var expectedResult = Comment.builder()
                .id(10)
                .comment("test comment")
                .build();


        CreateUpdateCommentDto createUpdateCommentDto = CreateUpdateCommentDto.builder()
                .comment("test comment")
                .build();

        var actualResult = createUpdateCommentDtoMapper.mapFrom(createUpdateCommentDto);
        actualResult.setId(10);

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);


    }

}
