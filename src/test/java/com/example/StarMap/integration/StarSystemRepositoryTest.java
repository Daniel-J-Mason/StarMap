package com.example.StarMap.integration;

import com.example.StarMap.entities.StarSystem;
import com.example.StarMap.objects.Coordinate;
import com.example.StarMap.repositories.StarSystemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StarSystemRepositoryTest {
    
    @Autowired
    private StarSystemRepository testRepository;
    
    @Test
    void findStarByNameTest() {
        //given
        StarSystem sol = new StarSystem("Sol", new Coordinate(0, 0, 0), new HashSet<>());
        testRepository.save(sol);
        //when
        StarSystem returnSystem = testRepository.findStarSystemByName("Sol");
        //then
        Assertions.assertEquals("Sol", returnSystem.getName());
    }
    
    @Test
    void starsWithinRangeOfTest() {
        //given
        List<StarSystem> testStars = new ArrayList<>();
        testStars.add(new StarSystem("Sol", new Coordinate(0, 0, 0), new HashSet<>()));
        testStars.add(new StarSystem("xStar", new Coordinate(100, 0, 0), new HashSet<>()));
        testStars.add(new StarSystem("yStar", new Coordinate(0, 100, 0), new HashSet<>()));
        testStars.add(new StarSystem("zStar", new Coordinate(0, 0, 100), new HashSet<>()));
        testStars.add(new StarSystem("comboStar", new Coordinate(24, 24, 24), new HashSet<>()));
        testStars.add(new StarSystem("lostStart", new Coordinate(200, 200, 200), new HashSet<>()));
        testRepository.saveAll(testStars);
        
        //when
        StarSystem origin = testRepository.findStarSystemByName("Sol");
        List<StarSystem> manualFilter = testStars.stream().filter(
                x -> (Math.sqrt(Math.pow(x.getCoordinate().getX(), 2) +
                        Math.pow(x.getCoordinate().getY(), 2) +
                        Math.pow(x.getCoordinate().getZ(), 2)) < 101)
        ).toList();
        
        //Then
        //TODO: Determine if filter should include or exclude self
        List<StarSystem> repositoryOutput = testRepository.systemsWithinRangeOf(origin, 101);
        Assertions.assertEquals(repositoryOutput, manualFilter);
    }
}
