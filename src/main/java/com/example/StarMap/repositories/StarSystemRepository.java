package com.example.StarMap.repositories;

import com.example.StarMap.DTOs.StarSystemDTO;
import com.example.StarMap.entities.StarSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StarSystemRepository extends JpaRepository<StarSystem, Long> {
    @Query("SELECT s FROM StarSystem s WHERE lower(s.name) = lower(?1)")
    StarSystem findStarSystemByName(String name);
    
    //SpEL binding?
    @Query("SELECT s " +
            "FROM StarSystem s " +
            "WHERE SQRT(" +
            "POWER(:#{#origin.coordinate.x} - s.coordinate.x, 2) + " +
            "POWER(:#{#origin.coordinate.y} - s.coordinate.y, 2) + " +
            "POWER(:#{#origin.coordinate.z} - s.coordinate.z, 2)) " +
            "< :#{#distance}")
    List<StarSystem> systemsWithinRangeOf(@Param("origin") StarSystem origin, @Param("distance") double distance);
    
    // JPA cannot rebind a blind query to both %q% and q%, duplicate query injected until a better solution is found
    @Query("SELECT " +
            "new com.example.StarMap.DTOs.StarSystemDTO(s.pk, s.id64, s.name,  " +
            "new com.example.StarMap.objects.Coordinate(s.coordinate.x, s.coordinate.y, s.coordinate.z)) " +
            "FROM StarSystem s " +
            "WHERE s.name ILIKE %:query% " +
            "ORDER BY " +
            "CASE WHEN s.name ILIKE :duplicateQuery% THEN 0 ELSE 1 END," +
            "s.name")
    List<StarSystemDTO> findByNameContains(@Param("query") String query, @Param("duplicateQuery") String duplicateQuery);
}