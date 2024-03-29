package com.example.StarMap.controllers;

import com.example.StarMap.DTOs.StarSystemDTO;
import com.example.StarMap.entities.StarSystem;
import com.example.StarMap.service.StarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/StarSystems")
@CrossOrigin(origins = "*")
public class StarSystemController {
    
    @Autowired
    private StarSystemService starSystemService;

    @GetMapping("/name/{name}")
    public StarSystem getSytemByName(@PathVariable String name){
        name = name.replaceAll("\\+", " ");
        return starSystemService.getStarSystem(name);
    }
    
    @GetMapping("/id/{id}")
    public StarSystem getSystemByID(@PathVariable Long id){
        return starSystemService.getStarSystem(id);
    }
    
    @PostMapping(value="/search",
    consumes="text/plain")
    public List<StarSystemDTO> starSystemSearch(@RequestBody String query){
        return starSystemService.findByNameContains(query);
    }
    
    @GetMapping("/withinDistance")
    public List<StarSystem> systemsInRangeOf(@RequestParam Long originKey, @RequestParam double distance) {
        StarSystem origin = starSystemService.getStarSystem(originKey);
        return starSystemService.systemsWithinRangeOf(origin, distance);
    }
}
