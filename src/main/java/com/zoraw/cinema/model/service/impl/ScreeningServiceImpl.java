package com.zoraw.cinema.model.service.impl;

import com.zoraw.cinema.model.db.mongo.ScreeningRepository;
import com.zoraw.cinema.model.db.mongo.mapper.ScreeningDaoMapper;
import com.zoraw.cinema.model.domain.Movie;
import com.zoraw.cinema.model.domain.Screening;
import com.zoraw.cinema.model.exception.ScreeningNotFoundException;
import com.zoraw.cinema.model.service.ScreeningService;
import com.zoraw.cinema.rest.dto.MovieWithScreeningsDto;
import com.zoraw.cinema.rest.dto.ScreeningDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
class ScreeningServiceImpl implements ScreeningService {

    private final ScreeningRepository screeningRepository;
    private final ScreeningDaoMapper screeningDaoMapper;

    @Override
    public List<MovieWithScreeningsDto> getScreenings(LocalDateTime from, LocalDateTime to) {

        Set<Screening> screenings = screeningRepository.findByTimeBetween(from, to);

        return screenings.stream()
                .map(Screening::getMovie)
                .distinct()
                .map(movie -> createMovieWithScreenings(screenings, movie))
                .sorted(Comparator.comparing(movieWithScreening -> movieWithScreening.getMovie().getTitle()))
                .collect(Collectors.toList());
    }

    private MovieWithScreeningsDto createMovieWithScreenings(Set<Screening> screenings, Movie movie) {
        return MovieWithScreeningsDto.builder()
                .movie(movie)
                .screenings(screenings.stream()
                        .filter(screening -> screening.getMovie().equals(movie))
                        .map(screening -> new ScreeningDto(screening.getId(), screening.getTime()))
                        .sorted(Comparator.comparing(ScreeningDto::getTime))
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public Screening getScreening(String screeningId) {
        return screeningRepository.findById(screeningId)
                .map(screeningDaoMapper::toScreening)
                .orElseThrow(() -> new ScreeningNotFoundException(screeningId));
    }
}
