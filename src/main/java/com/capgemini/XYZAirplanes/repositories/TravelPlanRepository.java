package com.capgemini.XYZAirplanes.repositories;


import com.capgemini.XYZAirplanes.models.TravelPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "travelplans")
public interface TravelPlanRepository extends JpaRepository<TravelPlan, Long> {
}
