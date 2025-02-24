package com.example.MovieReviewPlatform2.service.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceClient {
    @Value("${image.service.url}")
    private String imageServiceUrl;

    public String getPosterUrl(String posterId) {
        if (posterId.startsWith("posters/")) {
            posterId = posterId.substring(8); // Удаляем первые 8 символов
        }
        return imageServiceUrl + "/api/images/" + posterId ;
    }
}