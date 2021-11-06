package com.example.predavanjademo.web.controllers;

import com.example.predavanjademo.entities.Municipality;
import com.example.predavanjademo.services.MunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/municipality", produces = MediaType.APPLICATION_JSON_VALUE)
public class MunicipalityController {

    @Autowired
    private MunicipalityService municipalityService;

    @GetMapping
    public ResponseEntity<List<Municipality>> findAll(){
        List<Municipality> municipalities = this.municipalityService.findAll();
        return municipalities!=null
                ? new ResponseEntity<>(municipalities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Municipality> findById(@PathVariable(value = "id") Integer id){
        Municipality municipality = this.municipalityService.findById(id);
        return municipality!=null
                ? new ResponseEntity<>(municipality, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/mun-by-city-name")
    public ResponseEntity<List<Municipality>> findByCityName(@RequestParam(value = "city") String cityName){
        List<Municipality> municipalities = this.municipalityService.findByCityName(cityName);
        return municipalities!=null
                ? new ResponseEntity<>(municipalities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/mun-names-by-city-name")
    public ResponseEntity<List<String>> findNamesByCityName(@RequestParam(value = "city") String cityName){
        List<String> municipalities = this.municipalityService.findNamesByCityName(cityName);
        return municipalities!=null
                ? new ResponseEntity<>(municipalities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/mun-names-by-region/{id}")
    public ResponseEntity<List<String>> findNamesByRegion(@PathVariable(value = "id") Integer id){
        List<String> municipalities = this.municipalityService.findNamesByRegion(id);
        return municipalities!=null
                ? new ResponseEntity<>(municipalities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
