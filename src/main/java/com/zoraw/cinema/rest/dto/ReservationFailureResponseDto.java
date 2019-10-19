package com.zoraw.cinema.rest.dto;

import com.zoraw.cinema.model.domain.Screening;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class ReservationFailureResponseDto extends ReservationResponseDto {

    private static final String TOO_LATE_DESCRIPTION = "TOO_LATE_DESCRIPTION";
    private static final String BAD_SEAT_CONFIGURATION_DESCRIPTION = "BAD_SEAT_CONFIGURATION_DESCRIPTION";

    private String failureDescription;
    private Screening screening;

    public static ReservationFailureResponseDto createTooLateResponse() {
        return ReservationFailureResponseDto.builder()
                .failureDescription(TOO_LATE_DESCRIPTION)
                .build();
    }

    public static ReservationFailureResponseDto createBadSeatConfigurationResponse(Screening screening) {
        return ReservationFailureResponseDto.builder()
                .screening(screening)
                .failureDescription(BAD_SEAT_CONFIGURATION_DESCRIPTION)
                .build();
    }
}
