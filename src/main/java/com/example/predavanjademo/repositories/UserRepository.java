package com.example.predavanjademo.repositories;

import com.example.predavanjademo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {



}
