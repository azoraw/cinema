package com.zoraw.cinema.model.service.impl;

import com.zoraw.cinema.model.domain.TicketType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

interface TicketPriceCalculationService {

    BigDecimal calculateTotalAmount(Map<TicketType, Integer> tickets, LocalDateTime screeningTime, String voucher);
}
