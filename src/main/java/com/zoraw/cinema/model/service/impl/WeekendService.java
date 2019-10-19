package com.zoraw.cinema.model.service.impl;

import java.time.LocalDateTime;

interface WeekendService {
    boolean isWeekend(LocalDateTime dateTime);
}
