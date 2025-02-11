package com.example.MovieReviewPlatform2.service.impl;

import com.example.MovieReviewPlatform2.service.ImageService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

@Service
public class ImageServiceImpl implements ImageService {


    private final Path basePath = Path.of("F:/work/images");

    private ImageServiceImpl() {
    }

    public void upload(String imagePath, InputStream imageContent) throws IOException {
        System.out.println("image.base.url=F:/work/images:  " + basePath + "ImagePath:  " + imagePath);
        var imageFullPath = Path.of(String.valueOf(basePath), imagePath);
        try (imageContent) {
            Files.createDirectories(imageFullPath.getParent());
            Files.write(imageFullPath, imageContent.readAllBytes(), CREATE, TRUNCATE_EXISTING);
        }
    }

    public Optional<InputStream> get(String imagePath) throws IOException {
        var imageFullPath = Path.of(String.valueOf(basePath), imagePath);

        return Files.exists(imageFullPath)
                ? Optional.of(Files.newInputStream(imageFullPath))
                : Optional.empty();
    }
}