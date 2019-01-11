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
    CheckinRepository checkinRepository;

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    VenueRepository venueRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BreweryRepository breweryRepository;

    @PostMapping
    public boolean checkin(@RequestBody CheckinForm checkinForm){
        log.info("Creating checkin with form: " + checkinForm.toString());

        Beer beer = CheckInManager.createCheckin(beerRepository,venueRepository,userRepository,checkinRepository,checkinForm);
        CheckInManager.changeBeerRating(checkinRepository,beer,beerRepository);
        CheckInManager.changeBreweryRating(breweryRepository,beerRepository,beer);

        return true;
    }
}
