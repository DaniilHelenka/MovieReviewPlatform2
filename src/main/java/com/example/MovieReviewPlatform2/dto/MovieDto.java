package com.example.MovieReviewPlatform2.dto;

import lombok.*;

import java.time.LocalDate;



@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
public class MovieDto {
    Integer id;
    String name;
    String genre;
    String description;
    String poster_url;
    LocalDate release_date;
    Integer rating;

}
