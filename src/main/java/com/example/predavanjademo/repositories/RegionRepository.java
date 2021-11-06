package com.example.predavanjademo.repositories;

import com.example.predavanjademo.entities.City;
import com.example.predavanjademo.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {


}
