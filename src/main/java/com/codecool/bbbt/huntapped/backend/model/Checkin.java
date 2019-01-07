package com.codecool.bbbt.huntapped.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Checkin {

    @Id
    @GeneratedValue
    private Long id;

    private Double rating;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Beer beer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Venue venue;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private Users user;

    @Lob
    private String comment;
}
