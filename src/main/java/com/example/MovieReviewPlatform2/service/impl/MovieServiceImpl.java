package com.example.MovieReviewPlatform2.service.impl;

import com.example.MovieReviewPlatform2.dto.CreateMovieDto;
import com.example.MovieReviewPlatform2.dto.MovieDto;
import com.example.MovieReviewPlatform2.mapper.CreateMovieMapper;
import com.example.MovieReviewPlatform2.mapper.MovieMapper;
import com.example.MovieReviewPlatform2.repository.MovieRepository;
import com.example.MovieReviewPlatform2.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final CreateMovieMapper createMovieMapper;
    private final String imageServiceUrl = "http://localhost:8081/api/images/upload"; // ImageService URL
    private final RestTemplate restTemplate;


    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository,
                            MovieMapper movieMapper,
                            CreateMovieMapper createMovieMapper, RestTemplate restTemplate) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
        this.createMovieMapper = createMovieMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<MovieDto> findAll() {
        return movieRepository.findAll().stream()
                .map(movieMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> findAllPaginated(int page, int size) {
        return movieRepository.findAll(PageRequest.of(page - 1, size))
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

    public void uploadPoster(MultipartFile poster_url) {
        // Создайте тело запроса с использованием MultiValueMap
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("poster_url", poster_url.getResource());

        // Установите правильный заголовок Content-Type
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // Создайте HttpEntity с данными и заголовками
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);

        // Отправьте запрос через RestTemplate
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    imageServiceUrl, HttpMethod.POST, requestEntity, String.class
            );

            // Обработайте ответ от сервиса
            if (response.getStatusCode() == HttpStatus.OK) {
                // Успешная загрузка
            } else {
                // Обработать ошибку
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload poster to ImageService", e);
        }
    }
}

