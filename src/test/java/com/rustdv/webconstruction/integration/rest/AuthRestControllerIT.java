package com.rustdv.webconstruction.integration.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePersonRoleDto;
import com.rustdv.webconstruction.integration.IntegrationTestBase;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
public class AuthRestControllerIT extends IntegrationTestBase {

    private final MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Test
    void signUpTest() throws Exception {

        var personToSave = CreateUpdatePersonRoleDto.builder()
                .firstName("TEST")
                .email("TEST@gmail.com")
                .rawPassword("PASSWORD")
                .role("Специалист")
                .build();

        var response = mockMvc.perform(post("/api/v1/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(personToSave)));

        response.andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect((ResultMatcher) jsonPath("$.firstName", personToSave.getFirstName()));


    }
}
