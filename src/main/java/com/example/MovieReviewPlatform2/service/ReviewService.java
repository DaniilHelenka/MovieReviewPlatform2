package com.example.MovieReviewPlatform2.service;

import com.example.MovieReviewPlatform2.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    void addReview(Integer userId, Integer movieId, Integer rating, String comments);

    List<ReviewDto> findAllByMovieId(Integer movieId);
}
