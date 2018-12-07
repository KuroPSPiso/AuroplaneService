package com.capgemini.XYZAirplanes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aeroplane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private float fuel;

    public Aeroplane() {
    }

    public Aeroplane(String id, float fuel){
        this.id = id;
        this.fuel = fuel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getFuel() {
        return fuel;
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
    }
}
