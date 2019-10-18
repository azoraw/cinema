package com.zoraw.cinema.rest.dto;


import com.zoraw.cinema.model.domain.Movie;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MovieWithScreeningsDto {
    private Movie movie;
    private List<ScreeningDto> screenings;
}
