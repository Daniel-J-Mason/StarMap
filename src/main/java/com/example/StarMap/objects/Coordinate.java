package com.example.StarMap.objects;

import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Coordinate {
    private int x;
    private int y;
    private int z;
    
    public Coordinate(int x, int y, int z) {
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
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getZ() {
        return z;
    }
    
    public void setZ(int z) {
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
