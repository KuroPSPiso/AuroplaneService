package com.capgemini.XYZAirplanes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aeroplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float fuel;

    public Aeroplane() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getFuel() {
        return fuel;
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
    }
}
