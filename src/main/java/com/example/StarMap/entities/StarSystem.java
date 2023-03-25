package com.example.StarMap.entities;

import com.example.StarMap.objects.Coordinate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.Objects;
import java.util.Set;

@Entity
public class StarSystem extends KeyEntity {
    private Long id64;
    private String name;
    @Embedded
    private Coordinate coordinate;
    @OneToMany(mappedBy = "starSystem")
    private Set<Body> bodies;
    
    public StarSystem(){
        name = "N/A";
        coordinate = new Coordinate(0, 0, 0);
    }
    
    public StarSystem(String name, Coordinate coordinate, Set<Body> bodies) {
        this.name = name;
        this.coordinate = coordinate;
        this.bodies = bodies;
    }
    
    public double distanceFrom(StarSystem otherSystem){
        return coordinate.distance(otherSystem.getCoordinate());
    }
    
    public Long getId64() {
        return id64;
    }
    
    public void setId64(Long id64) {
        this.id64 = id64;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Coordinate getCoordinate() {
        return new Coordinate(coordinate.getX(), coordinate.getY(), coordinate.getZ());
    }
    
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = new Coordinate(coordinate.getX(), coordinate.getY(), coordinate.getZ());
    }
    
    public Set<Body> getBodies() {
        return bodies;
    }
    
    public void setBodies(Set<Body> bodies) {
        this.bodies = bodies;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StarSystem)) return false;
        StarSystem that = (StarSystem) o;
        return Objects.equals(name, that.name) && Objects.equals(coordinate, that.coordinate);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, coordinate);
    }
}
