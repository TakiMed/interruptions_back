package com.example.predavanjademo.web.controllers;

import com.example.predavanjademo.entities.City;
import com.example.predavanjademo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/city", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> findAll(){
        List<City> cities = this.cityService.findAll();
        return cities !=null
                ? new ResponseEntity<>(cities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/find-city-by-region/{id}")
    public ResponseEntity<List<City>> findByRegion(@PathVariable(value = "id") Integer regionId){
        List<City> cities = this.cityService.findByRegion(regionId);
        return cities !=null
                ? new ResponseEntity<>(cities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
