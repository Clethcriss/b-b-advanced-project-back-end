package com.codecool.bbbt.huntapped.backend.controller;

import com.codecool.bbbt.huntapped.backend.model.Beer;
import com.codecool.bbbt.huntapped.backend.repository.BeerRepository;
import com.codecool.bbbt.huntapped.backend.repository.BreweryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class BeersController {

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private BreweryRepository breweryRepository;

    @GetMapping("/beers")
    @CrossOrigin(origins = "http://192.168.160.216:3000")
    public List<Beer> getBeers() {
        return beerRepository.findAll();
    }

    @GetMapping("/beers/brewery-id={breweryId}")
    public List<Beer> getBeersByBreweryId(@PathVariable Long breweryId) {
        return beerRepository.findByBrewery(breweryRepository.findBreweryById(breweryId));
    }

    @GetMapping("/beers/style={style}")
    public List<Beer> getBeersByStyle(@PathVariable String style) {
        log.info("Style is: " + style);
        return beerRepository.findByType(style);
    }
}
