package com.capgemini.XYZAirplanes.repositories;

import com.capgemini.XYZAirplanes.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "cities")
public interface CityRepository extends JpaRepository<City, Long> {
}
