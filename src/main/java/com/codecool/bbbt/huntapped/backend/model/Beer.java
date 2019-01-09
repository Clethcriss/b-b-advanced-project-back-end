package com.codecool.bbbt.huntapped.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String type;
    private int ibu;
    private double abv;
    private double rating;
    // Many-to-One relationship
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private Brewery brewery;
    @Column(length=1000)
    private String description;
    private int numberOfRatings;
}
