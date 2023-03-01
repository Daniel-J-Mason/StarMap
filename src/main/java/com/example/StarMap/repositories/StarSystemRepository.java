package com.example.StarMap.repositories;

import com.example.StarMap.entities.StarSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StarSystemRepository extends JpaRepository<StarSystem, Long> {
    @Query("SELECT s FROM StarSystem s WHERE s.name = ?1")
    StarSystem findStarSystemByName(String name);
    
    //SpEL binding?
    @Query("SELECT s FROM StarSystem s WHERE SQRT(POWER(:#{#origin.coordinate.x} - s.coordinate.x, 2) + POWER(:#{#origin.coordinate.y} - s.coordinate.y, 2) + POWER(:#{#origin.coordinate.z} - s.coordinate.z, 2)) < :#{#distance}")
    List<StarSystem> systemsWithinRangeOf(@Param("origin") StarSystem origin, @Param("distance") double distance);
}