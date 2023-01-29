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
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static java.nio.file.StandardOpenOption.*;

@Component
@RequiredArgsConstructor
public class ImageLoader {

    @Value("${app.image.path}")
    private final String BASE_PATH;

    @Value("${app.download.path}")
    private final String BASE_PATH_FOR_DOWNLOAD;


    @SneakyThrows
    public void upload(Collection<MultipartFile> images, String folder) {

        var paths = images.stream()
                .map(multipartFile -> {
                    try {
                        var fullPath = Path.of(BASE_PATH, folder, multipartFile.getOriginalFilename());
                        Files.createDirectories(fullPath.getParent());
                        return Files.write(fullPath,
                                multipartFile.getBytes(), CREATE, TRUNCATE_EXISTING);
                    } catch (IOException e) {
                        throw new RuntimeException("exception message : ", e);
                    }

                }).toList();


    }


    @SneakyThrows
    public List<byte[]> download(Collection<String> imagesName, String folder) {

        return imagesName.stream()
                .map(s -> {
                    try {
                        var fullPath = Path.of(BASE_PATH, folder, s);
                        return Files.exists(fullPath) ?
                                Files.readAllBytes(fullPath) : new byte[0];
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).toList();

    }

    @SneakyThrows
    public byte[] downloadOneImage(String imageName, String folder) {

        try {
            var fullPath = Path.of(BASE_PATH, folder, imageName);
            return Files.exists(fullPath) ?
                    Files.readAllBytes(fullPath) : new byte[0];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
