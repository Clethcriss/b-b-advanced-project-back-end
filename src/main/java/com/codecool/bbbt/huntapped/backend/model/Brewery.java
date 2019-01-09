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
public class Brewery {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String country;
    private String description;
    private double rating;
    private int numberOfRatings;
}
