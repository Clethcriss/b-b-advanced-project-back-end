package com.codecool.bbbt.huntapped.backend;

import com.codecool.bbbt.huntapped.backend.model.*;
import com.codecool.bbbt.huntapped.backend.repository.BeerRepository;
import com.codecool.bbbt.huntapped.backend.repository.BreweryRepository;
import com.codecool.bbbt.huntapped.backend.repository.UserRepository;
import com.codecool.bbbt.huntapped.backend.repository.VenueRepository;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BackEndApplication {

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    BreweryRepository breweryRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(BackEndApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            List<Beer> beers = new ArrayList<>();
            List<Brewery> breweries = new ArrayList<>();
            List<Venue> venues = new ArrayList<>();
            beers.add(Beer.builder()
                    .name("Gentle Bastard IPA")
                    .brewery("HORIZONT BREWING")
                    .breweryId(new Long(4))
                    .abv(6.5)
                    .description("Kellemes világos narancs színű Amerikai IPA, amely szépen hozza a felhasznált amerikai komlók ízeit - Columbus, Simcoe, Mosaic, Amarillo - mellette a malátás profil is szépen előtérben marad.")
                    .ibu(63)
                    .rating(0)
                    .numberOfRatings(0)
                    .type("IPA")
                    .build()
            );

            beers.add(Beer.builder()
                    .name("Insulin Pump")
                    .brewery("Parody Brewing Artisanal Project")
                    .breweryId(new Long(7))
                    .description("Session Sugarshock Imperial Cake Stout. ")
                    .abv(9)
                    .ibu(25)
                    .rating(0)
                    .numberOfRatings(0)
                    .type("Imperial Stout")
                    .build());

            beers.add(Beer.builder()
                    .name("GreyJoy")
                    .brewery("Balkezes")
                    .breweryId(new Long(6))
                    .description("Earl Grey teával és bergamottal feldobott dupla IPA.\n" +
                                "Felhasznált komlók: Magnum, Cascade, Mosaic, Citra ")
                    .abv(9)
                    .ibu(99)
                    .rating(0)
                    .numberOfRatings(0)
                    .type("Imperial IPA")
                    .build());

            breweries.add(Brewery.builder()
                    .name("HORIZONT Brewing")
                    .country("Hungary")
                    .description("Who's the #GentleBastard now? Uncompromising KRAFT beers from Budapest (Hungary).")
                    .rating(0)
                    .numberOfRatings(0)
                    .build());

            breweries.add(Brewery.builder()
                    .name("Mad Scientist")
                    .country("Hungary")
                    .description("The new generation of craft brewers from Budapest.")
                    .rating(0)
                    .numberOfRatings(0)
                    .build());

            breweries.add(Brewery.builder()
                    .name("Balkezes")
                    .country("Hungary")
                    .description("Gerilla.\n" +
                            "Brewery.\n" +
                            "Hungary.")
                    .rating(0)
                    .numberOfRatings(0)
                    .build());

            breweries.add(Brewery.builder()
                    .name("Parody Brewing Artisanal Project")
                    .country("Hungary")
                    .description("Idióta receptek a végtelenen is túltolva Kővári Gergő és Rebák Tibi együttműködésében. Életfogytig tartó bérletváltás a sörfőzők poklába")
                    .rating(0)
                    .numberOfRatings(0)
                    .build());

            venues.add(Venue.builder()
                    .name("Hopaholic- In hop We Trust")
                    .address("38 Akácfa u. Budapest")
                    .country("Hungary")
                    .phoneNumber("+3616112415")
                    .facebookLink("https://facebook.com/657376574404974")
                    .type(VenueType.BAR)
                    .build());

            venues.add(Venue.builder()
                    .name("Kandalló Kézműves Pub")
                    .address("33 Kertész u. Budapest")
                    .country("Hungary")
                    .phoneNumber("+3617855568")
                    .facebookLink("https://facebook.com/KandalloPub")
                    .type(VenueType.GASTROPUB)
                    .build());

            venues.add(Venue.builder()
                    .name("Kis Pipa Craft Beer and More")
                    .address("38 Akácfa u. Budapest")
                    .country("Hungary")
                    .phoneNumber("+3615551606")
                    .facebookLink("https://facebook.com/437676119995612")
                    .type(VenueType.BAR)
                    .build());

            User user = User.builder()
                    .name("Beer Drinker")
                    .nickName("FancyDrunk32")
                    .totalCheckIns(0)
                    .build();

            for (Beer beer : beers) {
                beerRepository.save(beer);
            }
            for (Brewery brewery : breweries) {
                breweryRepository.save(brewery);
            }
            for (Venue venue : venues) {
                venueRepository.save(venue);
            }
            userRepository.save(user);
        };
    }

    @PostConstruct
    public void afterInit() {
        LOGGER.info(beerRepository.findAll().toString());
    }
}
