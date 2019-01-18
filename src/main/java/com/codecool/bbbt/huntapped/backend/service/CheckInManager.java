package com.codecool.bbbt.huntapped.backend.service;

import com.codecool.bbbt.huntapped.backend.model.*;
import com.codecool.bbbt.huntapped.backend.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CheckInManager {
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


    public void changeBeerRating(Beer beer){

        List<Checkin> allCheckins = checkinRepository.findByBeer(beer);
        double sumOfRatings = 0;
        for (Checkin currentCheckin: allCheckins) {
            sumOfRatings += currentCheckin.getRating();
        }
        double avgRating = sumOfRatings/allCheckins.size();
        avgRating = Math.round(avgRating * 100.0) / 100.0;
        Integer numberOfRatings = allCheckins.size();
        beerRepository.updateBeerRatingByBeerId(beer.getId(), avgRating, numberOfRatings);
        this.changeBreweryRating(beer);
    }

    public void changeBreweryRating(Beer beer){

        Brewery brewery = breweryRepository.findBreweryById(beer.getBrewery().getId());
        List<Beer> beersByBrewery = beerRepository.findByBrewery(brewery);
        double sumOfBeerRatings = 0;
        Integer numberOfBeersRated = 0;
        Integer numberOfCheckins = 0;
        for (Beer currentBeer:beersByBrewery) {
            if(currentBeer.getNumberOfRatings()>0){
                sumOfBeerRatings += currentBeer.getRating();
                numberOfBeersRated +=1;
            }
            numberOfCheckins += currentBeer.getNumberOfRatings();
        }
        double avgOfBeerRatings = sumOfBeerRatings/numberOfBeersRated;
        avgOfBeerRatings = Math.round(avgOfBeerRatings * 100.0) / 100.0;
        breweryRepository.updateBreweryRatingById(brewery.getId(),avgOfBeerRatings,numberOfCheckins);

    }

    public Beer createCheckin(CheckinForm checkinForm){

        Beer beer = beerRepository.getBeerById(checkinForm.getBeerId());
        Venue venue = venueRepository.findVenueById(checkinForm.getVenueId());
        User user = userRepository.findUserByUsername(checkinForm.getUsername());
        Checkin checkin = new Checkin();
        checkin.setBeer(beer);
        checkin.setDescription(checkinForm.getDescription());
        checkin.setRating(checkinForm.getRating());
        checkin.setUser(user);
        checkin.setVenue(venue);
        checkinRepository.save(checkin);
        log.info("User: {} checked in beer {} with a rating: {}",checkin.getUser().getUsername(), checkin.getBeer(),checkin.getRating());
        this.changeBeerRating(beer);
        return beer;
    }
}
