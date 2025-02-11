package com.example.MovieReviewPlatform2.service.impl;

import com.example.MovieReviewPlatform2.dto.CreateUserDto;
import com.example.MovieReviewPlatform2.entity.User;
import com.example.MovieReviewPlatform2.mapper.CreateUserMapper;
import com.example.MovieReviewPlatform2.mapper.UserMapper;
import com.example.MovieReviewPlatform2.repository.UserRepository;
import com.example.MovieReviewPlatform2.service.ImageService;
import com.example.MovieReviewPlatform2.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CreateUserMapper createUserMapper;
    private final ImageService imageService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder; // Добавляем PasswordEncoder

    public UserServiceImpl(UserRepository userRepository,
                           CreateUserMapper createUserMapper,
                           ImageService imageService,
                           UserMapper userMapper,
                           PasswordEncoder passwordEncoder) { // Внедряем PasswordEncoder
        this.userRepository = userRepository;
        this.createUserMapper = createUserMapper;
        this.imageService = imageService;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Integer create(CreateUserDto userDto) throws IOException {
        var userEntity = createUserMapper.mapFrom(userDto);

        // Хешируем пароль перед сохранением
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));

        // Загрузка изображения (если есть)
        if (userDto.getImage() != null) {
            imageService.upload(userEntity.getImage(), (InputStream) userDto.getImage());
        }

        userRepository.save(userEntity);
        return userEntity.getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }
}
