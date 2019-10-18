package com.zoraw.cinema.model.db.mongo.mapper;

import com.zoraw.cinema.model.db.mongo.dao.ReservationDao;
import com.zoraw.cinema.model.domain.Reservation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationDaoMapper {
    ReservationDao toReservationDao(Reservation reservation);
}
