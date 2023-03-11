package com.example.StarMap.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@MappedSuperclass
public class KeyEntity {
    
    @Id
    @Column(name = "PK", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Generated(GenerationTime.INSERT) // needed to set up postgres Primary Key Contraint
    private Long pk;
    
    public Long getPk() {
        return pk;
    }
    
    public void setPk(Long pk) {
        this.pk = pk;
    }
}
