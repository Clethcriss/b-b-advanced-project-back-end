package com.codecool.bbbt.huntapped.backend.repository;

import com.codecool.bbbt.huntapped.backend.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface VenueRepository extends JpaRepository<Venue, Long> {

    Venue findVenueById(Long id);

    List<Venue> findByNameContainingIgnoreCase(String nameChunk);
}
