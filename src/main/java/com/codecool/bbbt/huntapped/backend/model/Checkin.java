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
import java.util.Date;

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

    private Date date;

    @ManyToOne
    private Beer beer;

    @ManyToOne
    private Venue venue;

    @ManyToOne
    private User user;

    @Column(length=1000)
    private String description;


}
