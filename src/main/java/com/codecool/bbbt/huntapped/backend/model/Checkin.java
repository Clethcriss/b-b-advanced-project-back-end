package com.codecool.bbbt.huntapped.backend.model;

import com.codecool.bbbt.huntapped.backend.repository.BeerRepository;
import com.codecool.bbbt.huntapped.backend.repository.UserRepository;
import com.codecool.bbbt.huntapped.backend.repository.VenueRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Checkin {

    @Id
    @GeneratedValue
    private Long id;

    private Double rating;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Beer beer;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Venue venue;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private Users user;

    @Lob
    private String description;


}
