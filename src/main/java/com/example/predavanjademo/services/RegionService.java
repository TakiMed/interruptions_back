package com.example.predavanjademo.services;


import com.example.predavanjademo.entities.Region;
import com.example.predavanjademo.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<Region> findAll(){
        return this.regionRepository.findAll();
    }
}
