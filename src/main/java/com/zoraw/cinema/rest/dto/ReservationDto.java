package com.zoraw.cinema.rest.dto;

import com.zoraw.cinema.model.domain.Seat;
import com.zoraw.cinema.model.domain.TicketType;
import com.zoraw.cinema.rest.validation.LastName;
import com.zoraw.cinema.rest.validation.Name;
import com.zoraw.cinema.rest.validation.ValidReservation;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;
import java.util.Set;

@Data
@ValidReservation
public class ReservationDto {

    @Size(min = 3, max = 50)
    @NotBlank
    @Name
    private String firstName;

    @Size(min = 3, max = 50)
    @NotBlank
    @LastName
    private String lastName;

    @NotNull
    private String screeningId;

    @Size(min = 1)
    private Set<Seat> seats;

    @Size(min = 1)
    private Map<TicketType, Integer> tickets;
}
