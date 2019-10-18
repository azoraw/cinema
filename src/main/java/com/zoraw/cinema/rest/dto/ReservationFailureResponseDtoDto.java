package com.zoraw.cinema.rest.dto;

import com.zoraw.cinema.model.domain.Screening;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ReservationFailureResponseDtoDto extends ReservationResponseDto {

    private static final String TOO_LATE_DESCRIPTION = "TOO_LATE_DESCRIPTION";
    private static final String BAD_SEAT_CONFIGURATION_DESCRIPTION = "BAD_SEAT_CONFIGURATION_DESCRIPTION";

    private String failureDescription;

    public static ReservationFailureResponseDtoDto createTooLateResponse() {
        return ReservationFailureResponseDtoDto.builder()
                .failureDescription(TOO_LATE_DESCRIPTION)
                .build();
    }

    public static ReservationFailureResponseDtoDto createBadSeatConfigurationResponse(Screening screening) {
        return ReservationFailureResponseDtoDto.builder()
                .screening(screening)
                .failureDescription(BAD_SEAT_CONFIGURATION_DESCRIPTION)
                .build();
    }
}
