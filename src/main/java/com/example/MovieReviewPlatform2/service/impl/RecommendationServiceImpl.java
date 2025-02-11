package com.example.MovieReviewPlatform2.service.impl;

import com.example.MovieReviewPlatform2.entity.Movies;
import com.example.MovieReviewPlatform2.repository.MovieRepository;
import com.example.MovieReviewPlatform2.service.RecommendationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecommendationServiceImpl implements RecommendationService {
    private final MovieRepository movieRepository;
    public RecommendationServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public List<Movies> getTop10RatedMovies() {
        return movieRepository.findTop10ByOrderByRatingDesc();
    }
}
