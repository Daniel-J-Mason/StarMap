package com.example.StarMap.objects;

import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Coordinate {
    private float x;
    private float y;
    private float z;
    
    public Coordinate(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Coordinate(){}
    
    public double distance(Coordinate other){
        return Math.sqrt(
                Math.pow(x - other.getX(), 2)
                        + Math.pow(y - other.getY(), 2)
                        + Math.pow(z - other.getZ(), 2));
    }
    
    public float getX() {
        return x;
    }
    
    public void setX(float x) {
        this.x = x;
    }
    
    public float getY() {
        return y;
    }
    
    public void setY(float y) {
        this.y = y;
    }
    
    public float getZ() {
        return z;
    }
    
    public void setZ(float z) {
        this.z = z;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate that)) return false;
        return x == that.x && y == that.y && z == that.z;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
