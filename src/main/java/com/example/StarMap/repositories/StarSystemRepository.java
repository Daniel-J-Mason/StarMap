package com.example.StarMap.repositories;

import com.example.StarMap.entities.StarSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StarSystemRepository extends JpaRepository<StarSystem, Long> {
    @Query("SELECT s FROM StarSystem s WHERE s.name = ?1")
    StarSystem findStarSystemByName(String name);
}