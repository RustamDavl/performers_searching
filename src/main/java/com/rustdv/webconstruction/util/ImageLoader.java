package com.rustdv.webconstruction.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collection;

import static java.nio.file.StandardOpenOption.*;

@Component
@RequiredArgsConstructor
public class ImageLoader {

    @Value("${app.image.path}")
    private final String BASE_PATH;


    @SneakyThrows
    public void upload(Collection<MultipartFile> images, String folder) {

       var paths = images.stream()
                .map(multipartFile -> {
                    try {
                       return Files.write(Path.of(BASE_PATH, folder, multipartFile.getOriginalFilename()),
                                multipartFile.getBytes(), CREATE, TRUNCATE_EXISTING);
                    } catch (IOException e) {
                        throw new RuntimeException("exception message : ", e);
                    }

                }).toList();




    }





}
