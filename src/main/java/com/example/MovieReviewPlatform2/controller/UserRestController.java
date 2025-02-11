package com.example.MovieReviewPlatform2.controller;

import com.example.MovieReviewPlatform2.dto.UserResponse;
import com.example.MovieReviewPlatform2.dto.WatchlistDto;
import com.example.MovieReviewPlatform2.entity.Movies;
import com.example.MovieReviewPlatform2.entity.User;
import com.example.MovieReviewPlatform2.repository.UserRepository;
import com.example.MovieReviewPlatform2.service.ImageService;
import com.example.MovieReviewPlatform2.service.WatchlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final UserRepository userRepository;
    private final ImageService imageService;
    private final WatchlistService watchlistService;

    public UserRestController(UserRepository userRepository, ImageService imageService, WatchlistService watchlistService) {
        this.userRepository = userRepository;
        this.imageService = imageService;
        this.watchlistService = watchlistService;
    }

    @GetMapping
    public UserResponse getUserDetails(@AuthenticationPrincipal UserDetails userDetails) throws IOException {
        if (userDetails == null) {
            throw new RuntimeException("User not authenticated");
        }

        // Получаем пользователя из репозитория
        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Integer userId = user.getId();

        // Получаем и передаем информацию о пользователе, его изображении и списке фильмов
        String image = String.valueOf(imageService.get(user.getImage()));
        List<WatchlistDto> watchingList = watchlistService.getUserWatchlistByType(userId, "watching");
        List<WatchlistDto> watchedList = watchlistService.getUserWatchlistByType(userId, "watched");

        // Создаем объект ответа
        return new UserResponse(user, image, watchingList, watchedList);
    }
}
