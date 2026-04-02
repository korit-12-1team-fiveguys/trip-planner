package com.fiveguys.trip_planner.controller;

import com.fiveguys.trip_planner.dto.TripPlanRequestDto;
import com.fiveguys.trip_planner.dto.TripPlanResponseDto;
import com.fiveguys.trip_planner.entity.User;
import com.fiveguys.trip_planner.service.TripPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor
public class TripPlanController {
    private final TripPlanService tripPlanService;

    @PostMapping
    public ResponseEntity<TripPlanResponseDto> createTripPlan(@RequestBody TripPlanRequestDto requestDto,
                                                              @AuthenticationPrincipal User user) {
        TripPlanResponseDto responseDto = tripPlanService.createTripPlan(requestDto, user);

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripPlanResponseDto> getTripPlan(@PathVariable Long id) {
        TripPlanResponseDto responseDto = tripPlanService.getTripPlan(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<TripPlanResponseDto>> getMyTripPlans (@AuthenticationPrincipal User user) {
        List<TripPlanResponseDto> responseDto = tripPlanService.getMyTripPlans(user);
        return ResponseEntity.ok(responseDto);
    }
}
