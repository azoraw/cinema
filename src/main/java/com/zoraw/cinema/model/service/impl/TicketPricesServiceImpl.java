package com.zoraw.cinema.model.service.impl;

import com.zoraw.cinema.model.domain.TicketType;
import com.zoraw.cinema.model.service.TicketPricesService;
import com.zoraw.cinema.model.service.WeekendService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class TicketPricesServiceImpl implements TicketPricesService {

    private final WeekendService weekendService;

    @Value("${ticket.adult}")
    private BigDecimal adult;
    @Value("${ticket.student}")
    private BigDecimal student;
    @Value("${ticket.child}")
    private BigDecimal child;
    @Value("${ticket.weekendPriceOffSet}")
    private BigDecimal weekendPriceOffSet;

    private Map<TicketType, BigDecimal> regularPrices;
    private Map<TicketType, BigDecimal> weekendPrices;

    @PostConstruct
    private void initPrices() {
        regularPrices = new EnumMap<>(TicketType.class);
        weekendPrices = new EnumMap<>(TicketType.class);
        regularPrices.put(TicketType.ADULT, adult);
        regularPrices.put(TicketType.CHILD, child);
        regularPrices.put(TicketType.STUDENT, student);
        weekendPrices.put(TicketType.ADULT, adult.add(weekendPriceOffSet));
        weekendPrices.put(TicketType.CHILD, child.add(weekendPriceOffSet));
        weekendPrices.put(TicketType.STUDENT, student.add(weekendPriceOffSet));
    }

    @Override
    public Map<TicketType, BigDecimal> getPrices(LocalDateTime screeningTime) {
        return weekendService.isWeekend(screeningTime) ? weekendPrices : regularPrices;
    }


}
