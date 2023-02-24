package com.example.StarMap.service.impl;

import com.example.StarMap.entities.StarSystem;
import com.example.StarMap.repositories.StarSystemRepository;
import com.example.StarMap.service.StarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarSystemServiceImpl implements StarSystemService {
    
    @Autowired
    StarSystemRepository starSystemRepository;
    
    @Override
    public StarSystem getStarSystem(String name) {
        return starSystemRepository.findStarSystemByName(name);
    }
    
    @Override
    public StarSystem saveStarSystem(StarSystem starSystem) {
        return starSystemRepository.save(starSystem);
    }
    
    
}
