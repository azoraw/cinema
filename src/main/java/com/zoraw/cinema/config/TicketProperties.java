package com.zoraw.cinema.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigDecimal;

@Getter
@Setter
@ConfigurationProperties(prefix="ticket")
public class TicketProperties {

    private BigDecimal adult;
    private BigDecimal student;
    private BigDecimal child;
}

