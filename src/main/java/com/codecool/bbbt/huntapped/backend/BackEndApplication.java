package com.codecool.bbbt.huntapped.backend;

import com.codecool.bbbt.huntapped.backend.model.*;
import com.codecool.bbbt.huntapped.backend.repository.BeerRepository;
import com.codecool.bbbt.huntapped.backend.repository.BreweryRepository;
import com.codecool.bbbt.huntapped.backend.repository.UserRepository;
import com.codecool.bbbt.huntapped.backend.repository.VenueRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
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


    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }


    @Bean
    public CommandLineRunner init() {
        return args -> {
            List<Beer> horizontBeers = new ArrayList<>();
            List<Beer> balkezesBeers = new ArrayList<>();
            List<Beer> parodyBeers = new ArrayList<>();
            List<Venue> venues = new ArrayList<>();
            horizontBeers.add(Beer.builder()
                    .name("Night Shift (Vintage 2018)")
                    .abv(10.0)
                    .description("Our annual imperial stout. This year it hits an easy 10% ABV, more creamy and thick, with hints of dark chocolate and coffee. No fuss, just darkness.")
                    .ibu(0)
                    .rating(0)
                    .numberOfRatings(0)
                    .type("Imperial Stout")
                    .build()
            );

            horizontBeers.add(Beer.builder()
                    .name("Gentle Bastard IPA")
                    .abv(6.5)
                    .description("Kellemes világos narancs színű Amerikai IPA, amely szépen hozza a felhasznált amerikai komlók ízeit - Columbus, Simcoe, Mosaic, Amarillo - mellette a malátás profil is szépen előtérben marad. Egy nagy adag hidegkomlónak köszönhetően szépen jönnek a gyümölcsös jegyek, amelyek teljessé teszik a sört.")
                    .ibu(63)
                    .rating(0)
                    .numberOfRatings(0)
                    .type("IPA")
                    .build()
            );

            horizontBeers.add(Beer.builder()
                    .name("Rice Rice Baby")
                    .abv(6.5)
                    .description("Három világ találkozozása: rizses árpabor, szaké élesztő, tokaji aszús hordó. Komplex, gyümölcsösen illatos, hordós ízjegyek. \n" +
                            "\n" +
                            "Three worlds collide: rice barley wine, saké yeast, tokaj aszú wine barrels. Complex, fruity and oak notes. Drink next to the fireplace! ")
                    .ibu(40)
                    .rating(0)
                    .numberOfRatings(0)
                    .type("Barley wine")
                    .build()
            );

            parodyBeers.add(Beer.builder()
                    .name("Insulin Pump")
                    .description("Session Sugarshock Imperial Cake Stout. ")
                    .abv(9)
                    .ibu(25)
                    .rating(0)
                    .numberOfRatings(0)
                    .type("Imperial Stout")
                    .build());

            parodyBeers.add(Beer.builder()
                    .name("Jorum Massacre")
                    .description("Fruitengland Scandinavian Black Winter Farmhouse IIIIIIPA\n ")
                    .abv(0)
                    .ibu(0)
                    .rating(0)
                    .numberOfRatings(0)
                    .type("Farmhouse IPA")
                    .build());

            balkezesBeers.add(Beer.builder()
                    .name("GreyJoy")
                    .description("Earl Grey teával és bergamottal feldobott dupla IPA.\n" +
                            "Felhasznált komlók: Magnum, Cascade, Mosaic, Citra ")
                    .abv(9)
                    .ibu(99)
                    .rating(0)
                    .numberOfRatings(0)
                    .type("Imperial IPA")
                    .build());

            balkezesBeers.add(Beer.builder()
                    .name("Peeping Tom")
                    .description("Peeping Tom egy 1960-as brit horror / thriller. Meg Mike Patton második legfogyaszthatóbb bandájának a neve. A mozi nem hagyott nagy nyomot így csak a megjelenésben merítettünk belőle, a Peeping Tom albumot viszont sokat hallgattuk a Balkezesnél mikor az első kisüzemi American Pale Ale-en dolgoztunk.\n" +
                            "\n" +
                            "Egy kiforrott pale ale alapba először Simcoe komlót tettünk, hogy a kellő keserűséget elérjük. Majd még Simcoet, hogy a citrusos, picit mangós aromája meglegyen, és megSimcoeztuk, hogy egyértelműen kijöjjenek a Simcoe különös fenyős, földes jellegzetességei is. Aztán levezetésnek Simcoe. És mivel ezt így illik, egy ijesztő adaggal hidegSimcoeztunk erjedés után, biztos ami biztos.")
                    .abv(5.3)
                    .ibu(37)
                    .rating(0)
                    .numberOfRatings(0)
                    .type("APA")
                    .build());

            balkezesBeers.add(Beer.builder()
                    .name("Blood, Love, Rhetoric\n")
                    .description("\"Well, we can do you blood and love without the rhetoric, and we can do you blood and rhetoric without the love, and we can do you all three concurrent or consecutive. But we can't give you love and rhetoric without the blood. \n" +
                            "\n" +
                            "Blood is compulsory.\" \n" +
                            "\n" +
                            "― Tom Stoppard, Rosencrantz and Guildenstern are Dead\n" +
                            "\n" +
                            "A collaboration beer of Balkezes (HU) and Heist Craft (UK) for the event of Beer Week in Budapest 2018.\n" +
                            "\n" +
                            "a Blood Orange DIPA with the approach to mix the traditional american IPA with the hop burst New England style, and top up the whole with blood orange stuff. fruit content is close to ~300g for each liter.\n" +
                            "\n" +
                            "hops used: Mosaic, Magnum, Mandarina Bavaria, Amarillo")
                    .abv(7.8)
                    .ibu(85)
                    .rating(0)
                    .numberOfRatings(0)
                    .type("Imperial NE IPA")
                    .build());



            Brewery horizont = Brewery.builder()
                    .name("HORIZONT Brewing")
                    .country("Hungary")
                    .description("Who's the #GentleBastard now? Uncompromising KRAFT beers from Budapest (Hungary).")
                    .rating(0)
                    .numberOfRatings(0)
                    .build();

            Brewery balkezes = Brewery.builder()
                    .name("Balkezes")
                    .country("Hungary")
                    .description("Gerilla.\n" +
                            "Brewery.\n" +
                            "Hungary.")
                    .rating(0)
                    .numberOfRatings(0)
                    .build();

            Brewery parody = Brewery.builder()
                    .name("Parody Brewing Artisanal Project")
                    .country("Hungary")
                    .description("Idióta receptek a végtelenen is túltolva Kővári Gergő és Rebák Tibi együttműködésében. Életfogytig tartó bérletváltás a sörfőzők poklába")
                    .rating(0)
                    .numberOfRatings(0)
                    .build();

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


            for (Beer beer: horizontBeers) {
                beer.setBrewery(horizont);
            }
            for (Beer beer : parodyBeers) {
                beer.setBrewery(parody);
            }
            for (Beer beer : balkezesBeers) {
                beer.setBrewery(balkezes);
            }
            breweryRepository.save(balkezes);
            breweryRepository.save(parody);
            breweryRepository.save(horizont);
            beerRepository.saveAll(balkezesBeers);
            beerRepository.saveAll(parodyBeers);
            beerRepository.saveAll(horizontBeers);
            for (Venue venue : venues) {
                venueRepository.save(venue);
            }
        };
    }

    @PostConstruct
    public void afterInit() {
        log.info("Server test bean log");
    }
}
