package com.example.MovieReviewPlatform2.repository;

import com.example.MovieReviewPlatform2.entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Integer> {
    List<Reviews> findByMovieId(Integer movieId);
}