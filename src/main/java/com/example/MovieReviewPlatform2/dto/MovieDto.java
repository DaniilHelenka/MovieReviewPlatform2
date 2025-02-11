package com.example.MovieReviewPlatform2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;


@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class MovieDto {
    Integer id;
    String name;
    String genre;
    String description;
    String poster_url;
    LocalDate release_date;
    Integer rating;
}
