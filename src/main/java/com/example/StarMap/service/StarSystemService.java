package com.example.StarMap.service;


import com.example.StarMap.entities.StarSystem;

public interface StarSystemService {
    
    StarSystem getStarSystem(String name);
    
    StarSystem saveStarSystem(StarSystem starSystem);
}
