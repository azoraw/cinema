package com.zoraw.cinema.rest.dto;

import com.zoraw.cinema.model.domain.Screening;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ReservationResponseDto {

    protected Screening screening;
    private BigDecimal amount;
    private LocalDateTime expirationTime;

}
