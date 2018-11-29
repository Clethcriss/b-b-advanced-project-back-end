package com.codecool.bbbt.huntapped.backend.controller;

import com.codecool.bbbt.huntapped.backend.model.Brewery;
import com.codecool.bbbt.huntapped.backend.repository.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/brewery")
public class BreweryController {

    @Autowired
    private BreweryRepository breweryRepository;

    @GetMapping("/list")
    public List<Brewery> getBreweries() {
        return breweryRepository.findAll();
    }

    @GetMapping("/{name}")
    public Brewery getBrewery(@PathVariable("name") String name) {
        return breweryRepository.findBreweryByName(name);
    }
}
