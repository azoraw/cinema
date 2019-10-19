package com.zoraw.cinema.model.service;

import java.time.LocalDateTime;

public interface WeekendService {
    boolean isWeekend(LocalDateTime dateTime);
}
