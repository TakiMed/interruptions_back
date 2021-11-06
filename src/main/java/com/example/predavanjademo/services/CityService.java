package com.example.predavanjademo.services;

import com.example.predavanjademo.entities.City;
import com.example.predavanjademo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll(){
        return this.cityRepository.findAll();
    }

    public List<City> findByRegion(Integer regionId) {
        return this.cityRepository.findByRegionId(regionId);
    }
}
