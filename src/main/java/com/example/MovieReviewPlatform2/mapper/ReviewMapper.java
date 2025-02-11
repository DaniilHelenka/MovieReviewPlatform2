package com.example.MovieReviewPlatform2.mapper;

import com.example.MovieReviewPlatform2.dto.ReviewDto;
import com.example.MovieReviewPlatform2.entity.Reviews;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public ReviewDto mapFrom(Reviews review, Integer movieId) {
        return ReviewDto.builder()
                .id(review.getId())
                .movieId(movieId)
                .rating(review.getRating())
                .comments(review.getComments())
                .created_at(review.getCreatedAt())
                .build();
    }
}