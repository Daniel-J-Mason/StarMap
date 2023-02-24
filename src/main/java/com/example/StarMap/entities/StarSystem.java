package com.example.StarMap.entities;

import com.example.StarMap.objects.Coordinate;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import java.util.Objects;

@Entity
public class StarSystem extends KeyEntity {
    private String name;
    @Embedded
    private Coordinate coordinate;
    
    public StarSystem(){
        name = "N/A";
        coordinate = new Coordinate(0, 0, 0);
    }
    
    public StarSystem(String name, Coordinate coordinate) {
        this.name = name;
        this.coordinate = coordinate;
    }
    
    public double distanceFrom(StarSystem otherSystem){
        return coordinate.distance(otherSystem.getCoordinate());
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
