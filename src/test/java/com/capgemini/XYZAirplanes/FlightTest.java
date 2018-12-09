package com.capgemini.XYZAirplanes;

import com.capgemini.XYZAirplanes.exceptions.FlightDestinationIsOriginException;
import com.capgemini.XYZAirplanes.exceptions.PlaneUnavailableException;
import com.capgemini.XYZAirplanes.models.Aeroplane;
import com.capgemini.XYZAirplanes.models.Airport;
import com.capgemini.XYZAirplanes.models.FlightPlan;
import com.capgemini.XYZAirplanes.repositories.AeroplaneRepository;
import com.capgemini.XYZAirplanes.repositories.AirportRepository;
import com.capgemini.XYZAirplanes.repositories.FlightPlanRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FlightTest {

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    AeroplaneRepository aeroplaneRepository;

    @Autowired
    FlightPlanRepository flightPlanRepository;

    String plane1 = "A240";
    String plane2 = "A330";
    String plane3 = "Z40";
    String plane4 = "CA89";

    @Before
    public void Init()
    {

        Airport cityOfAmsterdam = new Airport();
        cityOfAmsterdam.setName("Amsterdam");
        Airport cityOfLondon = new Airport();
        cityOfLondon.setName("London");
        Airport cityOfParis = new Airport();
        cityOfParis.setName("Paris");
        Airport cityOfStockholm = new Airport();
        cityOfStockholm.setName("Stockholm");
        Airport cityOfBerlin = new Airport();
        cityOfBerlin.setName("Berlin");

        Collection<Airport> cities = new ArrayList<>();
        cities.add(cityOfAmsterdam);
        cities.add(cityOfLondon);
        cities.add(cityOfParis);
        cities.add(cityOfStockholm);
        cities.add(cityOfBerlin);

        this.airportRepository.saveAll(cities);

        Collection<Aeroplane> aeroplanes = new ArrayList<>();
        aeroplanes.add(new Aeroplane(this.plane1, 0f));
        aeroplanes.add(new Aeroplane(this.plane2, 0f));
        aeroplanes.add(new Aeroplane(this.plane3, 0f));
        aeroplanes.add(new Aeroplane(this.plane4, 0f));

        this.aeroplaneRepository.saveAll(aeroplanes);
    }

    public FlightTest()
    {}

    @Test
    public void TestFlight() throws FlightDestinationIsOriginException, PlaneUnavailableException {
        Collection<Airport> airports = this.airportRepository.findAll();
        Aeroplane aeroplane = this.aeroplaneRepository.findById(this.plane1);
        FlightPlan flightPlan;
        if(!this.aeroplaneRepository.isFlying(aeroplane.getId())) {
            flightPlan = CreateFlightplan(
                    aeroplane,
                    ((List<Airport>) airports).get(0),
                    ((List<Airport>) airports).get(1),
                    LocalDateTime.of(2018, 12, 10, 9, 0),
                    Duration.ofHours(2).plusMinutes(15)
            );
            flightPlanRepository.save(flightPlan);
        } else {
            throw new PlaneUnavailableException();
        }

        assertNotNull(flightPlan);
        assertTrue(this.aeroplaneRepository.isFlying(aeroplane.getId()));
        assertFalse(this.flightPlanRepository.readyForDeparture(flightPlan.getId()));
        aeroplane.addFuel(flightPlan.getExpectedFuelConsumption() + 100);
        assertTrue(this.flightPlanRepository.readyForDeparture(flightPlan.getId()));
    }

    //This step has to be reproduced on the website
    private static FlightPlan CreateFlightplan(Aeroplane aeroplane, Airport fromAirport, Airport toAirPort, LocalDateTime departureTime, Duration travelTime) throws FlightDestinationIsOriginException {
        if(fromAirport.equals(toAirPort)) throw new FlightDestinationIsOriginException();

        FlightPlan flightPlan = new FlightPlan();
        flightPlan.setAeroplane(aeroplane);
        flightPlan.setDepartureTime(departureTime);
        flightPlan.setToAirport(toAirPort);
        flightPlan.setFromAirport(fromAirport);
        flightPlan.setFlightDuration(travelTime);

        return flightPlan;
    }
}
