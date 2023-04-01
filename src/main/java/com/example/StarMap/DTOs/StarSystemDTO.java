package com.example.StarMap.DTOs;

import com.example.StarMap.objects.Coordinate;
import jakarta.persistence.Embedded;

import java.util.Objects;

public class StarSystemDTO{
    private Long pk;
    private Long id64;
    private String name;
    @Embedded
    private Coordinate coordinate;
    
    public StarSystemDTO(){
        id64 = -1L;
        name = "";
        coordinate = new Coordinate(0, 0, 0);
    }
    
    public StarSystemDTO(Long pk, Long id64, String name, Coordinate coordinate){
        this.pk = pk;
        this.id64 = id64;
        this.name = name;
        this.coordinate = coordinate;
    }
    
    public Long getPk() {
        return pk;
    }
    
    public void setPk(Long pk) {
        this.pk = pk;
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
        return coordinate;
    }
    
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StarSystemDTO that)) return false;
        return Objects.equals(id64, that.id64) && Objects.equals(name, that.name) && Objects.equals(coordinate, that.coordinate);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id64, name, coordinate);
    }
}
