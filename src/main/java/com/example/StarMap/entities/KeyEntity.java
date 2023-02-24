package com.example.StarMap.entities;

import jakarta.persistence.*;

@MappedSuperclass
public class KeyEntity {
    
    @Id
    @Column(name = "PK", unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long pk;
    
    public Long getPk() {
        return pk;
    }
    
    public void setPk(Long pk) {
        this.pk = pk;
    }
}
