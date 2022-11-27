package com.rustdv.webconstruction;


import lombok.Cleanup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebConstructionApplication {

    public static void main(String[] args) {

        @Cleanup var application = SpringApplication.run(WebConstructionApplication.class, args);

    }

}
