package com.rustdv.webconstruction.integration.controller;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePersonDto;
import com.rustdv.webconstruction.dto.createupdate.CreateUpdateResumeDto;
import com.rustdv.webconstruction.integration.IntegrationTestBase;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalTime;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RequiredArgsConstructor
@AutoConfigureMockMvc
public class ExecutorControllerIT extends IntegrationTestBase {

    private final Integer USER_ID = 10;

    private final MockMvc mockMvc;


    @Test
    void createResume() throws Exception {
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


        int userId = 10;


        mockMvc.perform(MockMvcRequestBuilders.post("/{id}/resumes", userId)
                        .param(createUpdateResumeDto.toString()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("/*/resumes"));

    }

    @Test
    void updatePersonProfile() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders.post("/executor/{id}/profile/update", 1)
                        .param("firstName", "UpdatedFirstname")

                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("/executor/*/profile"));
    }

}
