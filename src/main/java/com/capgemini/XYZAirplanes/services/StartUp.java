package com.capgemini.XYZAirplanes.services;

import com.capgemini.XYZAirplanes.models.Aeroplane;
import com.capgemini.XYZAirplanes.models.City;
import com.capgemini.XYZAirplanes.repositories.AeroplaneRepository;
import com.capgemini.XYZAirplanes.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class StartUp {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AeroplaneRepository aeroplaneRepository;

    @PostConstruct
    private void Initialise()
    {
        //initialise cities.
        City cityOfAmsterdam = new City();
        cityOfAmsterdam.setName("Amsterdam");
        City cityOfLondon = new City();
        cityOfLondon.setName("London");
        City cityOfParis = new City();
        cityOfParis.setName("Paris");
        City cityOfStockholm = new City();
        cityOfStockholm.setName("Stockholm");
        City cityOfBerlin = new City();
        cityOfBerlin.setName("Berlin");

        Collection<City> cities = new ArrayList<>();
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
