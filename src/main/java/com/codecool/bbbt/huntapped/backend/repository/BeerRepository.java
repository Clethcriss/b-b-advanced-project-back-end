package com.codecool.bbbt.huntapped.backend.repository;

import com.codecool.bbbt.huntapped.backend.model.Beer;
import com.codecool.bbbt.huntapped.backend.model.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BeerRepository extends JpaRepository<Beer, Long> {

    Beer getBeerById(Long id);

    List<Beer> findByNameContainingIgnoreCase(String nameChunk);

    List<Beer> findByBrewery(Brewery brewery);
}
