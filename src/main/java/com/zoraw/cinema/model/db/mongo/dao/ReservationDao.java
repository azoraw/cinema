package com.zoraw.cinema.model.db.mongo.dao;

import com.zoraw.cinema.model.domain.TicketType;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
import java.util.Set;

@Data
@Builder
@Document
public class ReservationDao {

    private String id;
    private String firstName;
    private String lastName;
    private String screeningId;
    private Set<SeatDao> seats;
    private Map<TicketType, Integer> tickets;
    private String voucher;

}
