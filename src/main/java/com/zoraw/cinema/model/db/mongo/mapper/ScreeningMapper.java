package com.zoraw.cinema.model.db.mongo.mapper;

import com.zoraw.cinema.model.db.mongo.dao.ScreeningDao;
import com.zoraw.cinema.model.dto.Screening;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScreeningMapper {
    Screening toScreeningDto(ScreeningDao screeningDao);
}
