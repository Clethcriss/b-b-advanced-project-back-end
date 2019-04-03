package com.codecool.bbbt.huntapped.backend.controller;


import com.codecool.bbbt.huntapped.backend.model.*;
import com.codecool.bbbt.huntapped.backend.repository.*;
import com.codecool.bbbt.huntapped.backend.service.CheckInManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
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

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public boolean checkin(@RequestBody CheckinForm checkinForm) {
        log.info("Creating checkin with form: " + checkinForm.toString());
        Beer beer = checkInManager.createCheckin(checkinForm);
        return true;
    }

    @GetMapping("/beerid={value}/limit={limit}/offset={offset}")
    public List<Checkin> getCheckinByBeer(@PathVariable("value") Long beerId, @PathVariable("limit") Integer limit, @PathVariable("offset") Integer offset) {
        List<Checkin> filteredCheckins = new ArrayList<>();
        List<Checkin> checkins = checkinRepository.findByBeerId(beerId);
        for (int i = offset; i < limit; i++) {
            if (i <= checkins.size() - 1) {
                filteredCheckins.add(checkins.get(i));
            } else break;
        }
        return filteredCheckins;
    }


    @GetMapping("/venueid={value}/limit={limit}/offset={offset}")
    public List<Checkin> getCheckinByVenue(@PathVariable("value") Long venueId, @PathVariable("limit") Integer limit, @PathVariable("offset") Integer offset) {
        List<Checkin> filteredCheckins = new ArrayList<>();
        List<Checkin> checkins = checkinRepository.findByVenueId(venueId);
        for (int i = offset; i < limit; i++) {
            if (i <= checkins.size() - 1) {
                filteredCheckins.add(checkins.get(i));
            } else break;
        }
        return filteredCheckins;
    }

    @GetMapping("/userid={value}/limit={limit}/offset={offset}")
    public List<Checkin> getCheckinByUser(@PathVariable("value") Long userId, @PathVariable("limit") Integer limit, @PathVariable("offset") Integer offset) {
        List<Checkin> filteredCheckins = new ArrayList<>();

        List<Checkin> checkins = checkinRepository.findByUserId(userId);
        for (int i = offset; i < limit; i++) {
            if (i <= checkins.size() - 1) {
                filteredCheckins.add(checkins.get(i));
            } else break;
        }
        return filteredCheckins;
    }

}
