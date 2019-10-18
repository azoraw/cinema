package com.zoraw.cinema.rest.mapper;

import com.zoraw.cinema.model.domain.Reservation;
import com.zoraw.cinema.rest.dto.ReservationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    Reservation toReservation(ReservationDto reservation);
}
