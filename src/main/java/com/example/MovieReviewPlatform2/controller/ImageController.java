
package com.example.MovieReviewPlatform2.controller;

import com.example.MovieReviewPlatform2.service.impl.ImageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequiredArgsConstructor
public class ImageController {

    private final ImageServiceImpl imageServiceImpl;

    @GetMapping("/images")
    public ResponseEntity<byte[]> getImage(@RequestParam String path) throws IOException {
        return imageServiceImpl.get(path)
                .map(image -> {
                    try (InputStream inputStream = image) {
                        byte[] imageBytes = inputStream.readAllBytes();
                        HttpHeaders headers = new HttpHeaders();
                        headers.add(HttpHeaders.CONTENT_TYPE, "application/octet-stream");
                        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
                    } catch (Exception e) {
                        return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
