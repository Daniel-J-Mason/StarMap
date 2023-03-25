package com.example.StarMap.repositories;

import com.example.StarMap.entities.Body;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyRepository extends JpaRepository<Body, Long> {
    
    @Query("SELECT b FROM Body b WHERE lower(b.name) = ?1")
    Body findBodyByName(String name);
}
