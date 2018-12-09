package com.capgemini.XYZAirplanes.models;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
public class FlightPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "aeroplane_id")
    private Aeroplane aeroplane;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "to_airport_id")
    private Airport toAirport;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "from_airport_id")
    private Airport fromAirport;

    private float expectedFuelConsumption = 2000f;

    private LocalDateTime departureTime;
    private Duration flightDuration;
    private float progression = 0;

    public FlightPlan() {
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

    public Airport getToAirport() {
        return toAirport;
    }

    public void setToAirport(Airport toAirport) {
        this.toAirport = toAirport;
    }

    public Airport getFromCity() {
        return fromAirport;
    }

    public void setFromAirport(Airport fromAirport) {
        this.fromAirport = fromAirport;
    }

    public float getExpectedFuelConsumption() {
        return expectedFuelConsumption;
    }

    public void setExpectedFuelConsumption(float expectedFuelConsumption) {
        this.expectedFuelConsumption = expectedFuelConsumption;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Duration getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(Duration flightDuration) {
        this.flightDuration = flightDuration;
    }
}
