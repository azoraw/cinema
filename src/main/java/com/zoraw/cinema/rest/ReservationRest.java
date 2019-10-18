package com.zoraw.cinema.rest;

import com.zoraw.cinema.model.service.ReservationService;
import com.zoraw.cinema.rest.dto.ReservationDto;
import com.zoraw.cinema.rest.dto.ReservationResponseDto;
import com.zoraw.cinema.rest.mapper.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/reservations")
@RestController
public class ReservationRest {

    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    @PostMapping
    public ResponseEntity<ReservationResponseDto> createReservation(@Valid @RequestBody ReservationDto reservation) {

        return ResponseEntity.ok(reservationService.create(reservationMapper.toReservation(reservation)));
    }

}
