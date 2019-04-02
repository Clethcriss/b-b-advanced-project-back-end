package com.codecool.bbbt.huntapped.backend.repository;

import com.codecool.bbbt.huntapped.backend.model.Beer;
import com.codecool.bbbt.huntapped.backend.model.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface CheckinRepository extends JpaRepository<Checkin,Long> {

    List<Checkin> findByBeer(Beer beer);

    @Query("SELECT c FROM Checkin c WHERE beer_id = ?1 ORDER BY date DESC")
    List<Checkin> findByBeerId(Long beerId);

    @Query("SELECT c FROM Checkin c WHERE venue_id = ?1 ORDER BY date DESC")
    List<Checkin> findByVenueId(Long venueId);
}
