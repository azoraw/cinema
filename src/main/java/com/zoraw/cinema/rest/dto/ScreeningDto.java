package com.zoraw.cinema.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScreeningDto {
    private String id;
    private LocalDateTime time;
}
