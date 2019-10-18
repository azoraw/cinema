package com.zoraw.cinema.model.service;

import com.zoraw.cinema.model.domain.Screening;
import com.zoraw.cinema.rest.dto.MovieWithScreeningsDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningService {

    List<MovieWithScreeningsDto> getScreenings(LocalDateTime from, LocalDateTime to);

    Screening getScreening(String screeningId);
}
