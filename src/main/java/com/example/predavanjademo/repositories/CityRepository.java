package com.example.predavanjademo.repositories;

import com.example.predavanjademo.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByRegionId(Integer regionId);
    List<City> findCitiesByRegion(Integer regionId);
}
