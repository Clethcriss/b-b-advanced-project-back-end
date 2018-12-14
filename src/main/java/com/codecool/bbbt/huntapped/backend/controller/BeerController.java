package com.codecool.bbbt.huntapped.backend.controller;

import com.codecool.bbbt.huntapped.backend.model.Beer;
import com.codecool.bbbt.huntapped.backend.repository.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/beer")
public class BeerController {


    @Autowired
    private BeerRepository beerRepository;

    @GetMapping("/id={id}")
    public Beer getBeers(@PathVariable("id") Long id) {
        return beerRepository.getBeerById(id);
    }

    @GetMapping("/search={value}")
    public List<Beer> getBeerByNameChunk(@PathVariable("value") String nameChunk) {
        List<Beer> beers = new ArrayList<>();
        if (nameChunk != "" || nameChunk != null) {
            beers = beerRepository.findByNameContainingIgnoreCase(nameChunk);
        }
        log.info("Result of the search on beers with " + nameChunk + " is " + beers.toString());

        return beers;}
}
