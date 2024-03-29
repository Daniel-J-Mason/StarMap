package com.example.StarMap.service;

import com.example.StarMap.DTOs.StarSystemDTO;
import com.example.StarMap.entities.StarSystem;

import java.util.List;

public interface StarSystemService {
    
    StarSystem getStarSystem(String name);
    
    StarSystem getStarSystem(Long key);
    
    StarSystem saveStarSystem(StarSystem starSystem);
    
    List<StarSystem> systemsWithinRangeOf(StarSystem origin, double range);
    
    List<StarSystemDTO> findByNameContains(String query);
}
