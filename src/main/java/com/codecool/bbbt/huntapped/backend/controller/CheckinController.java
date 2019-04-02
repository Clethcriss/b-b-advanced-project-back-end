package com.codecool.bbbt.huntapped.backend.controller;


import com.codecool.bbbt.huntapped.backend.model.*;
import com.codecool.bbbt.huntapped.backend.repository.*;
import com.codecool.bbbt.huntapped.backend.service.CheckInManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/checkin")
public class CheckinController {

    @Autowired
    CheckInManager checkInManager;

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    BreweryRepository breweryRepository;

    @Autowired
    CheckinRepository checkinRepository;

    @PostMapping
    public boolean checkin(@RequestBody CheckinForm checkinForm) {
        log.info("Creating checkin with form: " + checkinForm.toString());

        Beer beer = checkInManager.createCheckin(checkinForm);
        return true;
    }

    @GetMapping("/beerid={value}")
    public List<Checkin> getCheckinByBeer(@PathVariable("value") Long beerId) {
        return checkinRepository.findByBeerId(beerId);
    }

    @GetMapping("/breweryid={value}")
    public List<Checkin> getCheckinByBrewery(@PathVariable("value") Long breweryId) {
        List<Beer> beers = beerRepository.findByBrewery(breweryRepository.findBreweryById(breweryId));
        List<Checkin> checkins = null;
        for (Beer beer : beers) {
            if (checkins == null) {
                checkins = checkinRepository.findByBeerId(beer.getId());
            }
            checkins.addAll(checkinRepository.findByBeerId(beer.getId()));
        }
        return checkins;
    }

    @GetMapping("/venueid={value}")
    public List<Checkin> getCheckinByVenue(@PathVariable("value") Long venueId) {
        List<Checkin> checkins = checkinRepository.findByVenueId(venueId);
        return checkins;
    }
}
