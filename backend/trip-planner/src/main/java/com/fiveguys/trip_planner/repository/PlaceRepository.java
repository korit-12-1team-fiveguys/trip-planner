package com.fiveguys.trip_planner.repository;

import com.fiveguys.trip_planner.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Optional<Place> findByExternalPlaceId(String externalPlaceId);
}