package com.example.MovieReviewPlatform2.mapper;

import com.example.MovieReviewPlatform2.dto.UserDto;
import com.example.MovieReviewPlatform2.entity.User;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;
@Component
@NoArgsConstructor(access = PRIVATE)
public class UserMapper implements Mapper<User, UserDto> {
    @Override
    public UserDto mapFrom(User object) {
        return UserDto.builder()
                .id(object.getId())
                .name(object.getName())
                .image(object.getImage())
                .username(object.getUsername())
                .role(object.getRole())
                .build();
    }
}