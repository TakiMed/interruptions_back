package com.example.predavanjademo.services;


import com.example.predavanjademo.entities.Municipality;
import com.example.predavanjademo.repositories.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MunicipalityService {

    @Autowired
    private MunicipalityRepository municipalityRepository;

    public List<Municipality> findAll(){
        return this.municipalityRepository.findAll();
    }

    public List<Municipality> findByCityName(String cityName) {
        return this.municipalityRepository.findByCityName(cityName);
    }
    public List<String> findNamesByCityName(String cityName) {
        return this.municipalityRepository.findByCityName(cityName)
                .stream()
                .map(municipality -> municipality.getName())
                .collect(Collectors.toList());
    }

    public List<String> findNamesByRegion(Integer id) {
        return this.municipalityRepository.findByCity_RegionId(id)
                .stream()
                .map(municipality -> municipality.getName())
                .collect(Collectors.toList());
    }

    public Municipality findById(Integer id) {
        return this.municipalityRepository.findById(id).get();
    }
}
