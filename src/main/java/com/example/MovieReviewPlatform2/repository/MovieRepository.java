package com.example.MovieReviewPlatform2.repository;

import com.example.MovieReviewPlatform2.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer> {
     @Query("SELECT m FROM Movies m LEFT JOIN m.reviews r " +
           "GROUP BY m.id " +
           "ORDER BY AVG(r.rating) DESC")
    List<Movies> findTop10ByOrderByRatingDesc();
}

