package com.example.predavanjademo.repositories;

import com.example.predavanjademo.entities.Substation;
import com.example.predavanjademo.enums.VoltageTransformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubstationRepository extends JpaRepository<Substation, Integer> {

    Substation findSubstationById(Integer id);

    boolean existsByFullName(String fullName);

    Optional<List<Substation>> findByNameContaining(String searchTerm);

    Optional<List<Substation>> findByVoltageTransformationLike(VoltageTransformation hvlv);

    Optional<List<Substation>> findByFullNameLike(String fullName);
}
