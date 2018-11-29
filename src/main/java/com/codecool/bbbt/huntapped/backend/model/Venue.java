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
public class Venue {

    private @Id @GeneratedValue Long id;
    private String name;
    private String country;
    private String address;
    private String phoneNumber;
    private String facebookLink;
    private VenueType type;
}
