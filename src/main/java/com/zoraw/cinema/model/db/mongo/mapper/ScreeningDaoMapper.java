package com.zoraw.cinema.model.db.mongo.mapper;

import com.zoraw.cinema.model.db.mongo.dao.ScreeningDao;
import com.zoraw.cinema.model.domain.Screening;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScreeningDaoMapper {
    Screening toScreening(ScreeningDao screeningDao);
    ScreeningDao toScreeningDao(Screening screening);

}
