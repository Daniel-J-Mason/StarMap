package com.example.StarMap.integration;

import com.example.StarMap.entities.StarSystem;
import com.example.StarMap.objects.Coordinate;
import com.example.StarMap.repositories.StarSystemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StarSystemRepositoryTest {
    
    @Autowired
    private StarSystemRepository testRepository;
    
    @Test
    void findStarByNameTest() {
        //given
        StarSystem sol = new StarSystem("Sol", new Coordinate(0, 0, 0));
        testRepository.save(sol);
        //when
        StarSystem returnSystem = testRepository.findStarSystemByName("Sol");
        //then
    
        Assertions.assertEquals("Sol", returnSystem.getName());
    }
}
