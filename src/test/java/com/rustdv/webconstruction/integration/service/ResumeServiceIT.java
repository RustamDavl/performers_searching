package com.rustdv.webconstruction.integration.service;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateResumeDto;
import com.rustdv.webconstruction.entity.Address;
import com.rustdv.webconstruction.entity.Experience;
import com.rustdv.webconstruction.entity.Weekdays;
import com.rustdv.webconstruction.integration.IntegrationTestBase;
import com.rustdv.webconstruction.repository.ExperienceRepository;
import com.rustdv.webconstruction.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class ResumeServiceIT extends IntegrationTestBase {

    private final ResumeService resumeService;


    @Test
    void createResume() {


        var createUpdateResumeDto = CreateUpdateResumeDto.builder()
                .keyword("прораб")
                .team("один")
                .price("500")
                .measurement("за час")
                .mon(true)
                .tues(true)
                .wed(true)
                .tues(false)
                .fri(true)
                .sat(true)
                .sun(false)
                .startAt(LocalTime.of(6, 0))
                .endAt(LocalTime.of(22, 0))
                .experience("5 лет")
                .city("Казань")
                .street("Аметьевская магистраль")
                .houseNumber("16")
                .images(List.of(new MockMultipartFile("someDir", new byte[0])))
                .aboutMe("very cool worker")
                .build();

        Integer personId = 10;


        var readResume = resumeService.create(createUpdateResumeDto, personId);

        assertThat(readResume.getAddress().getStreet()).isEqualTo("Аметьевская магистраль");
        assertThat(readResume.getAboutMe()).isEqualTo("very cool worker");

    }
}
