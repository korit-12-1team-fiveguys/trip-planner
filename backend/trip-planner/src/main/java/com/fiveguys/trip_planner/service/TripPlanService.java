package com.fiveguys.trip_planner.service;

import com.fiveguys.trip_planner.dto.TripPlanRequestDto;
import com.fiveguys.trip_planner.dto.TripPlanResponseDto;
import com.fiveguys.trip_planner.dto.TripScheduleRequestDto;
import com.fiveguys.trip_planner.entity.*;

import com.fiveguys.trip_planner.repository.TripMemberRepository;
import com.fiveguys.trip_planner.repository.TripPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TripPlanService {
    private final TripPlanRepository tripPlanRepository;
    private final TripMemberRepository tripMemberRepository;

    @Transactional
    public TripPlanResponseDto createTripPlan(TripPlanRequestDto requestDto, User user) {
        TripPlan tripPlan = new TripPlan();
        tripPlan.setOwner(user);
        tripPlan.setTitle(requestDto.getTitle());
        tripPlan.setDestination(requestDto.getDestination());
        tripPlan.setStartDate(requestDto.getStartDate());
        tripPlan.setEndDate(requestDto.getEndDate());
        tripPlan.setStatus("PLANNING");

        if (requestDto.getSchedules() != null) {
            for (TripScheduleRequestDto scheduleRequestDto : requestDto.getSchedules()) {
                TripSchedule schedule = new TripSchedule();

                schedule.setTripPlan(tripPlan);

                schedule.setDayNumber(scheduleRequestDto.getDayNumber());
                schedule.setTitle(scheduleRequestDto.getTitle());
                schedule.setVisitOrder(scheduleRequestDto.getVisitOrder());
                schedule.setStartTime(scheduleRequestDto.getStartTime());
                schedule.setEndTime(scheduleRequestDto.getEndTime());
                schedule.setMemo(scheduleRequestDto.getMemo());
                schedule.setEstimatedStayMinutes(scheduleRequestDto.getEstimatedStayMinutes());

                tripPlan.getSchedules().add(schedule);
            }
        }

        TripPlan savePlan = tripPlanRepository.save(tripPlan);

        TripMember ownerMember = new TripMember();
        ownerMember.setTripPlan(savePlan);
        ownerMember.setUser(user);
        ownerMember.setRole("OWNER");
        tripMemberRepository.save(ownerMember);


        return new TripPlanResponseDto(savePlan);
    }

    @Transactional(readOnly = true)
    public TripPlanResponseDto getTripPlan(Long tripId) {
        TripPlan tripPlan = tripPlanRepository.findById(tripId)
                .orElseThrow(() -> new IllegalArgumentException("해당 여행 계획을 찾을 수 없습니다."));
        return new TripPlanResponseDto(tripPlan);
    }

    @Transactional(readOnly = true)
    public List<TripPlanResponseDto> getMyTripPlans(User user) {
        List<TripMember> memberships = tripMemberRepository.findByUser(user);

        return memberships.stream()
                .map(member -> new TripPlanResponseDto(member.getTripPlan()))
                .collect(Collectors.toList());
    }
}
