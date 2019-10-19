package com.zoraw.cinema.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigDecimal;
import java.time.DayOfWeek;

@Getter
@Setter
@ConfigurationProperties(prefix="ticket")
public class TicketProperties {

    private BigDecimal adult;
    private BigDecimal student;
    private BigDecimal child;
    private BigDecimal weekendPriceOffSet;
    private BigDecimal voucherDiscount;
    private int weekendStartHour;
    private DayOfWeek weekendStartDay;
    private int weekendStopHour;
    private DayOfWeek weekendStopDay;
}

