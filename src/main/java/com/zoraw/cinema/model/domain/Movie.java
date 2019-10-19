package com.zoraw.cinema.model.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class Movie {

    private String title;
    private String description;
}
