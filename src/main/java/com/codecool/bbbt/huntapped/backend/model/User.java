package com.codecool.bbbt.huntapped.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private @Id @GeneratedValue Long id;
    private String name;
    private String nick;
    private int totalCheckIns;

}
