package com.zoraw.cinema.model.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
@Builder
public class Reservation {

    private String firstName;
    private String lastName;
    private String screeningId;
    private Set<Seat> seats;
    private Map<TicketType, Integer> tickets;


}
