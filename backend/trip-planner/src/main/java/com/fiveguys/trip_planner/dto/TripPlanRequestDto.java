package com.fiveguys.trip_planner.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class TripPlanRequestDto {
    private String title;
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
}
