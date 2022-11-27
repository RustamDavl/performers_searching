package com.rustdv.webconstruction.integration;

import com.rustdv.webconstruction.integration.annotation.IT;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;



@Sql({
        "classpath:sql/data.sql"
})
@IT
public abstract class IntegrationTestBase {


    private static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:14.1");

    @BeforeAll
    static void runContainer() {
        container.start();
    }

    @DynamicPropertySource
    static void postgresProperties(DynamicPropertyRegistry registry) {

        registry.add("spring.datasource.url", container::getJdbcUrl);


    }





}
