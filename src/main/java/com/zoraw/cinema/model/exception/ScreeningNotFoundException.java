package com.zoraw.cinema.model.exception;

public class ScreeningNotFoundException extends BusinessException {

    public ScreeningNotFoundException(String screeningId) {
        super(String.format("Screening not found: %s", screeningId));
    }
}
