package com.zoraw.cinema.model.service;

import com.zoraw.cinema.model.domain.TicketType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public interface TicketPricesService {
    Map<TicketType, BigDecimal> getPrices(LocalDateTime screeningTime);
}
