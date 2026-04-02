package com.fiveguys.trip_planner.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter @Setter
@NoArgsConstructor
public class TripScheduleRequestDto {
    private Long placeId;
    private String title;
    private Integer dayNumber;
    private Integer visitOrder;
    private LocalTime startTime;
    private LocalTime endTime;
    private String memo;
    private Integer estimatedStayMinutes;
}
