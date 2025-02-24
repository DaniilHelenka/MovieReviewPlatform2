package com.example.MovieReviewPlatform2.service.impl;

import com.example.MovieReviewPlatform2.dto.ReviewDto;
import com.example.MovieReviewPlatform2.entity.Movies;
import com.example.MovieReviewPlatform2.entity.Reviews;
import com.example.MovieReviewPlatform2.mapper.ReviewMapper;
import com.example.MovieReviewPlatform2.repository.MovieRepository;
import com.example.MovieReviewPlatform2.repository.ReviewRepository;
import com.example.MovieReviewPlatform2.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final ReviewMapper reviewMapper;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             MovieRepository movieRepository,
                             ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
        this.reviewMapper = reviewMapper;
    }

    @Override
    public void addReview(Integer userId, Integer movieId, Integer rating, String comments) {
        // Получение фильма из репозитория
        Movies movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Фильм с id " + movieId + " не найден."));

        // Создание и сохранение нового отзыва
        Reviews review = Reviews.builder()
                .userId(userId)
                .movie(movie)
                .rating(rating)
                .comments(comments)
                .createdAt(LocalDateTime.now())
                .build();

        reviewRepository.save(review);
    }

    @Override
    public List<ReviewDto> findAllByMovieId(Integer movieId) {
        // Проверка наличия фильма
        if (!movieRepository.existsById(movieId)) {
            throw new RuntimeException("Фильм с id " + movieId + " не найден.");
        }

        // Получение отзывов и их преобразование в DTO
        return reviewRepository.findByMovieId(movieId).stream()
                .map(review -> reviewMapper.mapFrom(review, movieId))
                .collect(Collectors.toList());
    }
}
