package com.capgemini.XYZAirplanes.models;

import javax.persistence.*;

@Entity
public class TravelPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "aeroplane_id")
    private Aeroplane aeroplane;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tocity_id")
    private City toCity;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "fromcity_id")
    private City fromCity;

    private float expectedFuelConsumption = 2000f;

    public TravelPlan() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aeroplane getAeroplane() {
        return aeroplane;
    }

    public void setAeroplane(Aeroplane aeroplane) {
        this.aeroplane = aeroplane;
    }

    public City getToCity() {
        return toCity;
    }

    public void setToCity(City toCity) {
        this.toCity = toCity;
    }

    public City getFromCity() {
        return fromCity;
    }

    public void setFromCity(City fromCity) {
        this.fromCity = fromCity;
    }

    public float getExpectedFuelConsumption() {
        return expectedFuelConsumption;
    }

    public void setExpectedFuelConsumption(float expectedFuelConsumption) {
        this.expectedFuelConsumption = expectedFuelConsumption;
    }
}
