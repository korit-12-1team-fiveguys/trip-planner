package com.fiveguys.trip_planner.repository;

import com.fiveguys.trip_planner.entity.TripMember;
import com.fiveguys.trip_planner.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripMemberRepository extends JpaRepository<TripMember, Long> {
    List<TripMember> findByUser(User user);
}