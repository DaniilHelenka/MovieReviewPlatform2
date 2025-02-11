package com.example.MovieReviewPlatform2.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class ReviewDto {
    Integer id;
    Integer movieId;
    Integer rating;
    String comments;
    LocalDateTime created_at;
}
