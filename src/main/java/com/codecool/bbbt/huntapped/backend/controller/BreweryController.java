package com.codecool.bbbt.huntapped.backend.controller;

import com.codecool.bbbt.huntapped.backend.model.Brewery;
import com.codecool.bbbt.huntapped.backend.repository.BreweryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/brewery")
public class BreweryController {

    @Autowired
    private BreweryRepository breweryRepository;

    @GetMapping("/id={id}")
    public Brewery getBrewery(@PathVariable("id") Long id) {
        return breweryRepository.findBreweryById(id);
    }

    @GetMapping("/search={value}")
    public List<Brewery> findBreweries(@PathVariable("value") String nameChunk) {
        List<Brewery> breweries = new ArrayList<>();
        if (nameChunk != "" || nameChunk != null) {
            breweries = breweryRepository.findByNameContainingIgnoreCase(nameChunk);
        }
        log.info("Result of the search on breweries: " + breweries.toString());
        return breweries;
    }
}
