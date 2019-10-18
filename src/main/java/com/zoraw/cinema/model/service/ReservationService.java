package com.zoraw.cinema.model.service;

import com.zoraw.cinema.model.domain.Reservation;
import com.zoraw.cinema.rest.dto.ReservationResponseDto;

public interface ReservationService {

    ReservationResponseDto create(Reservation reservation);

}
