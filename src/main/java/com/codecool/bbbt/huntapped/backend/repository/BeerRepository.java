package com.codecool.bbbt.huntapped.backend.repository;

import com.codecool.bbbt.huntapped.backend.model.Beer;
import com.codecool.bbbt.huntapped.backend.model.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface BeerRepository extends JpaRepository<Beer, Long> {

    Beer getBeerById(Long id);

    List<Beer> findByNameContainingIgnoreCase(String nameChunk);

    List<Beer> findByBrewery(Brewery brewery);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Beer beer set beer.rating =:rating, beer.numberOfRatings=:numberOfRatings where beer.id =:beerId")
    void updateBeerRatingByBeerId(@Param("beerId") Long beerId,@Param("rating") double rating, @Param("numberOfRatings") Integer numberOfRatings);

}
