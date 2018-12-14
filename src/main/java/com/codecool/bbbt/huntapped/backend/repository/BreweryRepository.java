package com.codecool.bbbt.huntapped.backend.repository;

import com.codecool.bbbt.huntapped.backend.model.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BreweryRepository extends JpaRepository<Brewery, Long> {

    List<Brewery> findByNameContainingIgnoreCase(String nameChunk);

    Brewery findBreweryById(Long id);
}
