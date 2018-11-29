package com.codecool.bbbt.huntapped.backend.controller;

import com.codecool.bbbt.huntapped.backend.model.Venue;
import com.codecool.bbbt.huntapped.backend.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VenuesController {

    @Autowired
    VenueRepository venueRepository;

    @GetMapping("/venues")
    public List<Venue> getVenues() {
        return venueRepository.findAll();
    }
}
