package com.zoraw.cinema.model.service.impl;

import com.zoraw.cinema.model.domain.TicketType;
import com.zoraw.cinema.model.service.TicketPriceCalculationService;
import com.zoraw.cinema.model.service.TicketPricesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class TicketPriceCalculationServiceImpl implements TicketPriceCalculationService {

    private final TicketPricesService ticketPricesService;

    @Override
    public BigDecimal calculateTotalAmount(Map<TicketType, Integer> tickets, LocalDateTime screeningTime) {
        Map<TicketType, BigDecimal> prices = ticketPricesService.getPrices(screeningTime);
        return tickets.entrySet()
                .stream()
                .map(entry -> prices.get(entry.getKey()).multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
