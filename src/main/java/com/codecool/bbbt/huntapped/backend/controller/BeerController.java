package com.codecool.bbbt.huntapped.backend.controller;

import com.codecool.bbbt.huntapped.backend.model.Beer;
import com.codecool.bbbt.huntapped.backend.repository.BeerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/beer")
public class BeerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeerController.class);

    @Autowired
    private BeerRepository beerRepository;

    @GetMapping("/{id}")
    public Beer getBeers(@PathVariable("id") Long id) {
        return beerRepository.getBeerById(id);
    }

    @GetMapping("/search/{value}")
    public List<Beer> getBeerByNameChunk(@PathVariable("value") String nameChunk) {
        List<Beer> beers = beerRepository.findByNameContainingIgnoreCase(nameChunk);
        LOGGER.info("Result of the search on beers: " + beers.toString());
        return beers;}
}
