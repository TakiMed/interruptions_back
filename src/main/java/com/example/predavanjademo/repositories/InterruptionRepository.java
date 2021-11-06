package com.example.predavanjademo.repositories;

import com.example.predavanjademo.entities.Interruption;
import com.example.predavanjademo.enums.VoltageLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterruptionRepository extends JpaRepository<Interruption, Integer> {
    @Query(value = "select interruption from Interruption interruption " +
            "where interruption.voltageLevel = :voltage")
    List<Interruption> getByVoltageLevel(@Param("voltage")VoltageLevel voltage);
}

