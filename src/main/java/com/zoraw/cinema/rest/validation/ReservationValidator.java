package com.zoraw.cinema.rest.validation;

import com.zoraw.cinema.rest.dto.ReservationDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ReservationValidator implements ConstraintValidator<ValidReservation, ReservationDto> {

    @Override
    public boolean isValid(ReservationDto reservation, ConstraintValidatorContext context) {
        return reservation.getSeats().size() == getNumberOfAllTickets(reservation);
    }

    private int getNumberOfAllTickets(ReservationDto reservation) {
        return reservation.getTickets()
                .values()
                .stream()
                .mapToInt(value -> value)
                .sum();
    }
}
