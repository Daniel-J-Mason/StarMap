package com.example.StarMap.service.impl;

import com.example.StarMap.entities.Body;
import com.example.StarMap.repositories.BodyRepository;
import com.example.StarMap.service.BodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodyServiceImpl implements BodyService {
    
    @Autowired
    BodyRepository bodyRepository;
    
    @Override
    public Body getBody(String name) {
        return bodyRepository.findBodyByName(name);
    }
}
