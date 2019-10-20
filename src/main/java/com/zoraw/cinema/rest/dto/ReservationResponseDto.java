package com.zoraw.cinema.rest.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ReservationResponseDto {

    private BigDecimal amount;
    private LocalDateTime expirationTime;

}
