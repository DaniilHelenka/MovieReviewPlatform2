package com.example.MovieReviewPlatform2.mapper;

import org.springframework.stereotype.Component;

@Component
public interface Mapper<F, T> {

    T mapFrom(F object);

}
