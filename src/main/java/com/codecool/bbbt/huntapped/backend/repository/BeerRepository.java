package com.codecool.bbbt.huntapped.backend.repository;

import com.codecool.bbbt.huntapped.backend.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeerRepository extends JpaRepository<Beer, Long> {

    Beer getBeerById(Long id);

    List<Beer> findByNameContainingIgnoreCase(String nameChunk);
}
