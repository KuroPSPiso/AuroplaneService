package com.capgemini.XYZAirplanes.repositories;


import com.capgemini.XYZAirplanes.models.FlightPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "flightplans")
public interface FlightPlanRepository extends JpaRepository<FlightPlan, Long> {
}
