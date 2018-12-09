package com.capgemini.XYZAirplanes.repositories;


import com.capgemini.XYZAirplanes.models.FlightPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "flightplans")
public interface FlightPlanRepository extends JpaRepository<FlightPlan, Long> {
    @Query("SELECT CASE WHEN COUNT(f) > 0 THEN TRUE ELSE FALSE END FROM FlightPlan f JOIN Aeroplane a ON f.aeroplane.id = a.id AND f.id =?1 AND f.expectedFuelConsumption <= a.fuel")
    boolean readyForDeparture(long id);

}
