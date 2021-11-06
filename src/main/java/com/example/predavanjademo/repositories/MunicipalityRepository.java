package com.example.predavanjademo.repositories;

import com.example.predavanjademo.entities.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Integer> {
    List<Municipality> findByCityName(String cityName);

    List<Municipality> findByCity_RegionId(Integer id);

}
