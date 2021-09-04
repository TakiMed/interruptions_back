package com.example.predavanjademo.repositories;

import com.example.predavanjademo.entities.Prekid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrekidRepository extends JpaRepository<Prekid, Integer> {
}
