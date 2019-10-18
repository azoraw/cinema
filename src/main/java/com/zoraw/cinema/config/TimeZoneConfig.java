package com.zoraw.cinema.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class TimeZoneConfig {

    @Value("${spring.jackson.time-zone}")
    TimeZone timeZone;

    @Bean
    public void initTimeZone() {
        TimeZone.setDefault(timeZone);
    }
}
