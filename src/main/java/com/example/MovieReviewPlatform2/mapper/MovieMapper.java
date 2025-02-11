package com.example.MovieReviewPlatform2.mapper;

import com.example.MovieReviewPlatform2.dto.MovieDto;
import com.example.MovieReviewPlatform2.entity.Movies;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Component
@NoArgsConstructor(access = PRIVATE)
public class MovieMapper implements Mapper<Movies, MovieDto> {
    @Override
    public MovieDto mapFrom(Movies object) {
        return MovieDto.builder()
                .id(object.getId())
                .name(object.getName())
                .genre(object.getGenre())
                .description(object.getDescription())
                .release_date(object.getRelease_date())
                .poster_url(object.getPoster_url())
                .build();
    }
}
