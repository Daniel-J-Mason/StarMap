package com.example.StarMap.controllers;

import com.example.StarMap.entities.Body;
import com.example.StarMap.entities.StarSystem;
import com.example.StarMap.service.BodyService;
import com.example.StarMap.service.StarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/StarSystems")
public class StarSystemController {
    
    @Autowired
    private StarSystemService starSystemService;
    
    @Autowired
    private BodyService bodyService;
    
    @GetMapping("/name/{name}")
    public StarSystem getSytemByName(@PathVariable String name){
        return starSystemService.getStarSystem(name);
    }
    
    @GetMapping("/withinDistance")
    public List<StarSystem> systemsInRangeOf(@RequestParam Long originKey, @RequestParam double distance){
        StarSystem origin = starSystemService.getStarSystem(originKey);
        return starSystemService.systemsWithinRangeOf(origin, distance);
    }
    
    @GetMapping("/body/{name}")
    public Body getByName(@PathVariable String name){
        name = name.toLowerCase();
        return bodyService.getBody(name);
    }
    
    @GetMapping("/autoCompleteName")
    public List<String> autoCompleteStarSystem(@RequestParam String substring){
        if (substring.length() >= 3){
            return starSystemService.autoCompleteStarSystem(substring);
        }
        return new ArrayList<>();
    }
}
