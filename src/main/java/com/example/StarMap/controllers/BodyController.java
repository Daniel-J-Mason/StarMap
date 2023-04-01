package com.example.StarMap.controllers;

import com.example.StarMap.entities.Body;
import com.example.StarMap.service.BodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/Bodies")
@CrossOrigin(origins = "*")
public class BodyController {
    
    @Autowired
    private BodyService bodyService;
    
    @GetMapping("/id/{id}")
    public Body getByID(@PathVariable Long id){
        return  bodyService.getBody(id);
    }
    
    @GetMapping("/name/{name}")
    public Body getByName(@PathVariable String name){
        name = name.replaceAll("\\+", " ");
        return bodyService.getBody(name);
    }
    
}
