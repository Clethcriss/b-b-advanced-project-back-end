package com.codecool.bbbt.huntapped.backend;

import com.codecool.bbbt.huntapped.backend.model.Beer;
import com.codecool.bbbt.huntapped.backend.model.Type;
import com.codecool.bbbt.huntapped.backend.repository.BeerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class BackEndApplication {

    @Autowired
    private BeerRepository beerRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(BackEndApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            Beer beer1 = Beer.builder()
                    .name("Gentle Bastard IPA")
                    .brewery("HORIZONT BREWING")
                    .abv(6.5)
                    .description("Kellemes világos narancs színű Amerikai IPA, amely szépen hozza a felhasznált amerikai komlók ízeit - Columbus, Simcoe, Mosaic, Amarillo - mellette a malátás profil is szépen előtérben marad.")
                    .ibu(63)
                    .rating(3.6)
                    .numberOfRatings(0)
                    .type(Type.IPA)
                    .build();
            Beer beer2 = Beer.builder()
                    .name("Insulin Pump")
                    .brewery("Parody Brewing Artisanal Project")
                    .abv(9)
                    .description("Session Sugarshock Imperial Cake Stout. ")
                    .ibu(25)
                    .rating(3.4)
                    .numberOfRatings(0)
                    .type(Type.IMPERIAL_STOUT)
                    .build();
            beerRepository.save(beer1);
            beerRepository.save(beer2);
        };
    }

    @PostConstruct
    public void afterInit() {
        LOGGER.info(beerRepository.findAll().toString());
        LOGGER.info("TEST");
    }
}
