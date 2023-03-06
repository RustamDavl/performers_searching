package com.rustdv.webconstruction.util;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

import static java.nio.file.StandardOpenOption.*;

@Component
@RequiredArgsConstructor
public class ImageLoader {

    @Value("${app.image.path}")
    private final String BASE_PATH;

    @Value("${app.download.path}")
    private final String BASE_PATH_FOR_DOWNLOAD;


    @SneakyThrows
    public void uploadAllImages(Collection<MultipartFile> images, String folder) {

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
    public List<byte[]> downloadAllImages(Collection<String> imagesName, String folder) {

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
