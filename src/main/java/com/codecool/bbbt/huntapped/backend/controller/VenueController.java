package com.codecool.bbbt.huntapped.backend.controller;


import com.codecool.bbbt.huntapped.backend.model.Venue;
import com.codecool.bbbt.huntapped.backend.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Venue")
public class VenueController {

    @Autowired
    private VenueRepository venueRepository;

    @GetMapping("/{id}")
    public Venue getVenueById(@PathVariable("id") Long id) {
        return venueRepository.findVenueById(id);
    }
}
