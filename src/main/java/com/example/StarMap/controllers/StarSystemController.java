package com.example.StarMap.controllers;

import com.example.StarMap.entities.StarSystem;
import com.example.StarMap.service.StarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

@RestController
@RequestMapping(value = "/api/StarSystem")
public class StarSystemController {
    
    @Autowired
    private StarSystemService starSystemService;
    
    @GetMapping("/{name}")
    public StarSystem getSytemByName(@PathVariable String name){
        return starSystemService.getStarSystem(name);
    }
    
    @PostMapping(
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StarSystem> saveStarSystem(@RequestBody StarSystem newStarSystem) throws ServerException {
        StarSystem starSystem = starSystemService.saveStarSystem(newStarSystem);
        if (starSystem == null){
            throw new ServerException("Could not post starSystem");
        } else {
            return  new ResponseEntity<>(starSystem, HttpStatus.CREATED);
        }
    }
}
