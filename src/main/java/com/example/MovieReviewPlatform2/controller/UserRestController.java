package com.example.MovieReviewPlatform2.controller;

import com.example.MovieReviewPlatform2.dto.UserResponse;
import com.example.MovieReviewPlatform2.entity.User;
import com.example.MovieReviewPlatform2.repository.UserRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/user/profile")
public class UserRestController {

    private final UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
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

        // Создаем объект ответа
        return new UserResponse(user);
    }
}
