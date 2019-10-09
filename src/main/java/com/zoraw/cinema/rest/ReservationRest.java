package com.zoraw.cinema.rest;

import com.zoraw.cinema.model.dto.Reservation;
import com.zoraw.cinema.model.dto.ReservationResponse;
import com.zoraw.cinema.model.service.ReservationService;
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

    @PostMapping
    public ResponseEntity<ReservationResponse> createReservation(@Valid @RequestBody Reservation reservation) {

        return ResponseEntity.ok(reservationService.create(reservation));
    }

}
