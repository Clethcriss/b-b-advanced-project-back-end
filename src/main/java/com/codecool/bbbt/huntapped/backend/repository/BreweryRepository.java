package com.codecool.bbbt.huntapped.backend.repository;

import com.codecool.bbbt.huntapped.backend.model.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface BreweryRepository extends JpaRepository<Brewery, Long> {

    List<Brewery> findByNameContainingIgnoreCase(String nameChunk);

    Brewery findBreweryById(Long id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Brewery brewery set brewery.rating =:rating, brewery.numberOfRatings=:numberOfRatings where brewery.id =:id")
    void updateBreweryRatingById(@Param("id") Long id, @Param("rating") double rating, @Param("numberOfRatings") Integer numberOfRatings);
}
