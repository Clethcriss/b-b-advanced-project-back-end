package com.codecool.bbbt.huntapped.backend.repository;

import com.codecool.bbbt.huntapped.backend.model.Venue;
import com.codecool.bbbt.huntapped.backend.model.VenueType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class VenueRepositoryTest {

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void saveOneSimple() {
        Venue testVenue = Venue.builder()
                .address("Akacfa utca 38")
                .country("Hungary")
                .name("Hopaholic")
                .phoneNumber("+36 1 446 78 656")
                .facebookLink("https://facebook.com/hopaholic")
                .type(VenueType.BAR)
                .build();
        venueRepository.save(testVenue);

        List<Venue> venueList = venueRepository.findAll();
        assertThat(venueList).hasSize(1);
    }


}