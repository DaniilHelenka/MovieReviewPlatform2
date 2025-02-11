package com.example.MovieReviewPlatform2.service.impl;

import com.example.MovieReviewPlatform2.dto.CreateMovieDto;
import com.example.MovieReviewPlatform2.dto.MovieDto;
import com.example.MovieReviewPlatform2.mapper.CreateMovieMapper;
import com.example.MovieReviewPlatform2.mapper.MovieMapper;
import com.example.MovieReviewPlatform2.repository.MovieRepository;
import com.example.MovieReviewPlatform2.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final ImageServiceImpl imageService;
    private final CreateMovieMapper createMovieMapper;


    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper, ImageServiceImpl imageService, CreateMovieMapper createMovieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
        this.imageService = imageService;
        this.createMovieMapper = createMovieMapper;
    }

    @Override
    public List<MovieDto> findAll() {
        return movieRepository.findAll().stream()
                .map(movieMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> findAllPaginated(int page, int size) {
        return movieRepository.findAll( PageRequest.of(page - 1, size))
                .stream()
                .map(movieMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MovieDto> findById(Integer id) {
        return movieRepository.findById(id)
                .map(movieMapper::mapFrom);
    }

    public void addMovie(CreateMovieDto movieDto) {
        var movieEntity = createMovieMapper.mapFrom(movieDto);
        movieRepository.save(movieEntity);
    }

    @Override
    public boolean deleteMovie(Integer id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void moveToWatched(int movieId) {

    }
}
