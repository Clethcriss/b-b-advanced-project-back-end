package com.codecool.bbbt.huntapped.backend.controller;

import com.codecool.bbbt.huntapped.backend.model.Brewery;
import com.codecool.bbbt.huntapped.backend.repository.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BreweriesController {

    @Autowired
    private BreweryRepository breweryRepository;

    @GetMapping("/breweries")
    public List<Brewery> getBreweries() {
        return breweryRepository.findAll();
    }
}
