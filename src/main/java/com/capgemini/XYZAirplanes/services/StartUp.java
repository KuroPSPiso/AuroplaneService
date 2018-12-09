package com.capgemini.XYZAirplanes.services;

import com.capgemini.XYZAirplanes.models.Aeroplane;
import com.capgemini.XYZAirplanes.models.Airport;
import com.capgemini.XYZAirplanes.repositories.AeroplaneRepository;
import com.capgemini.XYZAirplanes.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class StartUp {

    @Autowired
    private AirportRepository cityRepository;

    @Autowired
    private AeroplaneRepository aeroplaneRepository;

    @PostConstruct
    private void Initialise()
    {
        //initialise cities.
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

        this.cityRepository.saveAll(cities);

        Collection<Aeroplane> aeroplanes = new ArrayList<>();
        aeroplanes.add(new Aeroplane("A240", 0f));
    }
}
