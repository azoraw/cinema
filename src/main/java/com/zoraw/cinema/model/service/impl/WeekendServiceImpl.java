package com.zoraw.cinema.model.service.impl;

import com.zoraw.cinema.model.service.WeekendService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Service
public class WeekendServiceImpl implements WeekendService {

    @Value("${ticket.weekendStartHour}")
    private int weekendStartHour;
    @Value("${ticket.weekendStartDay}")
    private DayOfWeek weekendStartDay;
    @Value("${ticket.weekendStopHour}")
    private int weekendStopHour;
    @Value("${ticket.weekendStopDay}")
    private DayOfWeek weekendStopDay;

    @Override
    public boolean isWeekend(LocalDateTime screeningTime) {
        return isAfterWeekendStart(screeningTime)
                && isBeforeWeekendStop(screeningTime);
    }

    private boolean isAfterWeekendStart(LocalDateTime screeningTime) {
        return weekendStartDay.getValue() <= screeningTime.getDayOfWeek().getValue()
                && weekendStartHour <= screeningTime.getHour();
    }

    private boolean isBeforeWeekendStop(LocalDateTime screeningTime) {
        return weekendStopDay.getValue() >= screeningTime.getDayOfWeek().getValue()
                && weekendStopHour > screeningTime.getHour();
    }
}
