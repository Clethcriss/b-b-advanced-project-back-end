package com.codecool.bbbt.huntapped.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private Type type;
    private int ibu;
    private double abv;
    private double rating;
    private String brewery;
    private String description;
    private int numberOfRatings;

}
