package com.example.MovieReviewPlatform2.dto;

import com.example.MovieReviewPlatform2.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private User user;
}
