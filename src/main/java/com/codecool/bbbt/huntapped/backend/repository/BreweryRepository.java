package com.codecool.bbbt.huntapped.backend.repository;

import com.codecool.bbbt.huntapped.backend.model.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BreweryRepository extends JpaRepository<Brewery, Long> {


    // TODO look after spring data repository documentation
    /*@Query("SELECT * FROM brewery WHERE name IS :name")
    Brewery getBreweryByName(@Param("name") String name);*/

    Brewery findBreweryByName(String name);
}
