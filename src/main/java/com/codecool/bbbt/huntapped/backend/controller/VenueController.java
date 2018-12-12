package com.codecool.bbbt.huntapped.backend.controller;


import com.codecool.bbbt.huntapped.backend.model.Venue;
import com.codecool.bbbt.huntapped.backend.repository.VenueRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/venue")
public class VenueController {

    @Autowired
    private VenueRepository venueRepository;

    @GetMapping("/{id}")
    public Venue getVenueById(@PathVariable("id") Long id) {
        return venueRepository.findVenueById(id);
    }

    @GetMapping("/search/{value}")
    public List<Venue> findVenueByGivenNameCunk(@PathVariable("value") String nameChunk) {
        List<Venue> venues = venueRepository.findByNameContainingIgnoreCase(nameChunk);
        log.info("Result of the search on venues: " + venues.toString());
        return venues;
    }
}
