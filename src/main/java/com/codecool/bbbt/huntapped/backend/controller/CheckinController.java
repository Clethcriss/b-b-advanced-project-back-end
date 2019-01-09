package com.codecool.bbbt.huntapped.backend.controller;


import com.codecool.bbbt.huntapped.backend.model.*;
import com.codecool.bbbt.huntapped.backend.repository.BeerRepository;
import com.codecool.bbbt.huntapped.backend.repository.CheckinRepository;
import com.codecool.bbbt.huntapped.backend.repository.UserRepository;
import com.codecool.bbbt.huntapped.backend.repository.VenueRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/checkin")
public class CheckinController {

    @Autowired
    CheckinRepository checkinRepository;

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    VenueRepository venueRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public boolean checkin(@RequestBody CheckinForm checkinForm){
        log.info("Creating checkin with form: " + checkinForm.toString());
        Beer beer = beerRepository.getBeerById(checkinForm.getBeerId());
        Venue venue = venueRepository.findVenueById(checkinForm.getVenueId());
        Users user = userRepository.findUserByUsername(checkinForm.getUsername());
        Checkin checkin = new Checkin();
        checkin.setBeer(beer);
        checkin.setDescription(checkinForm.getDescription());
        checkin.setRating(checkinForm.getRating());
        checkin.setUser(user);
        checkin.setVenue(venue);
        checkinRepository.save(checkin);
        log.info("User: {} checked in beer {} with a rating: {}",checkin.getUser().getUsername(), checkin.getBeer(),checkin.getRating());
        return true;
    }
}
