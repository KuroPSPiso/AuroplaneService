package com.capgemini.XYZAirplanes.repositories;

import com.capgemini.XYZAirplanes.models.Aeroplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "areoplanes")
public interface AeroplaneRepository extends JpaRepository<Aeroplane, Long> {
}
