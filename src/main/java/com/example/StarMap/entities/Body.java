package com.example.StarMap.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.hypersistence.utils.hibernate.type.basic.PostgreSQLHStoreType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.HashMap;

@Entity
@AllArgsConstructor
@NoArgsConstructor @Getter @Setter
public class Body extends KeyEntity {
    Long id64;
    Long bodyId;
    String name;
    String type;
    String subType;
    Long distanceToArrival;
    boolean isLandable;
    double gravity;
    double earthMasses;
    double radius;
    Long surfaceTemperature;
    double surfacePressure;
    String volcanismType;
    String atmosphereType;
    @Type(PostgreSQLHStoreType.class)
    @Column(columnDefinition = "hstore")
    HashMap<String, String> atmosphereComposition;
    @Type(PostgreSQLHStoreType.class)
    @Column(columnDefinition = "hstore")
    HashMap<String, String> solidComposition;
    String terraformingState;
    double orbitalPeriod;
    double semiMajorAxis;
    double orbitalEccentricity;
    double orbitalInclination;
    double argOfPeriapsis;
    double rotationalPeriod;
    boolean rotationalPeriodTidallyLocked;
    double axialTilt;
    @Type(PostgreSQLHStoreType.class)
    @Column(columnDefinition = "hstore")
    HashMap<String, String> materials;
    @ManyToOne(optional = true)
    @JoinColumn(name = "system_id", nullable = true)
    @JsonIgnore
    StarSystem starSystem;
}
