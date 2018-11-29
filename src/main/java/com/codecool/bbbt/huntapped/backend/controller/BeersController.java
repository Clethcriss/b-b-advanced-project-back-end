package com.codecool.bbbt.huntapped.backend.controller;

import com.codecool.bbbt.huntapped.backend.model.Beer;
import com.codecool.bbbt.huntapped.backend.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BeersController {

    @Autowired
    private BeerRepository beerRepository;

    @GetMapping("/beers")
    @CrossOrigin(origins = "http://192.168.160.216:3000")
    public List<Beer> getBeers() {
        return beerRepository.findAll();
    }
}
