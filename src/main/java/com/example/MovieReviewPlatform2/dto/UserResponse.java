package com.example.MovieReviewPlatform2.dto;

import com.example.MovieReviewPlatform2.entity.Movies;
import com.example.MovieReviewPlatform2.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private User user;
    private String image;
    private List<WatchlistDto> watchingList;
    private List<WatchlistDto> watchedList;
}
