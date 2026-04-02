package com.fiveguys.trip_planner.dto;

import com.fiveguys.trip_planner.entity.TripSchedule;
import lombok.Getter;


import java.time.LocalTime;

@Getter
public class TripScheduleResponseDto {
    private final Long id;
    private final Integer dayNumber;
    private final String title;
    private final Integer visitOrder;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final String memo;
    private final Integer estimatedStayMinutes;

    public TripScheduleResponseDto(TripSchedule schedule) {
        this.id = schedule.getId();
        this.dayNumber = schedule.getDayNumber();
        this.title = schedule.getTitle();
        this.visitOrder = schedule.getVisitOrder();
        this.startTime = schedule.getStartTime();
        this.endTime = schedule.getEndTime();
        this.memo = schedule.getMemo();
        this.estimatedStayMinutes = schedule.getEstimatedStayMinutes();
    }
}
