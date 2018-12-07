package com.capgemini.XYZAirplanes.repositories;

import com.capgemini.XYZAirplanes.models.Aeroplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "aeroplanes")
public interface AeroplaneRepository extends JpaRepository<Aeroplane, Long> {
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN TRUE ELSE FALSE END FROM FlightPlan f JOIN Aeroplane a ON f.aeroplane.id = a.id AND f.progression < 1")
    boolean isFlying();
}
