package com.zoraw.cinema.model.service.impl;

import com.zoraw.cinema.model.domain.TicketType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

interface TicketPricesService {
    Map<TicketType, BigDecimal> getPrices(LocalDateTime screeningTime);
}
