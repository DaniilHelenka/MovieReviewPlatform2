package com.example.MovieReviewPlatform2.service;

import com.example.MovieReviewPlatform2.dto.CreateUserDto;
import com.example.MovieReviewPlatform2.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.IOException;
import java.util.Optional;

public interface UserService extends UserDetailsService { // Подключаем Spring Security UserDetailsService
    Optional<User> getUserByUsername(String username);

    Integer create(CreateUserDto userDto) throws IOException;
}
