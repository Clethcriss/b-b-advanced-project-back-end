package com.codecool.bbbt.huntapped.backend.controller;


import com.codecool.bbbt.huntapped.backend.model.*;
import com.codecool.bbbt.huntapped.backend.repository.*;
import com.codecool.bbbt.huntapped.backend.service.CheckInManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
