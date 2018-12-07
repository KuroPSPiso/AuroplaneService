package com.capgemini.XYZAirplanes.repositories;

import com.capgemini.XYZAirplanes.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "airports")
public interface AirportRepository extends JpaRepository<Airport, Long> {
}
