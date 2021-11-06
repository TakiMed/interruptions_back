package com.example.predavanjademo.services;

import com.example.predavanjademo.entities.Substation;
import com.example.predavanjademo.enums.VoltageTransformation;
import com.example.predavanjademo.mappers.ISubstationMapper;
import com.example.predavanjademo.mappers.SubstationMapper;
import com.example.predavanjademo.repositories.SubstationRepository;
import com.example.predavanjademo.web.dto.SubstationDTO;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubstationService {

    @Autowired
    private SubstationRepository substationRepository;
    @Autowired
    private SubstationMapper substationMapper;
    @Autowired
    private ISubstationMapper iSubstationMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(SubstationService.class);

    public SubstationDTO getSubstationById(Integer id) {
        return iSubstationMapper.mapSubstationToDTO(substationRepository.findById(id).get());
    }

    public Substation getSubstationByName(String fullName) throws EntityNotFoundException {
        Optional<List<Substation>> subList = substationRepository.findByFullNameLike(fullName);
        if (subList.isPresent()) return subList.get().stream().findFirst().get();
        else throw new EntityNotFoundException("No substation with fullName " + fullName + " not found");
    }

    public Substation create(Substation substation) {
        return substationRepository.save(substation);
    }

    public List<SubstationDTO> getAllSubstations() {
        return substationRepository.findAll()
                .stream()
                .map(substationMapper::mapSubstationToDTO)
                .collect(Collectors.toList());
    }

    public SubstationDTO updateSubstation(Integer id, SubstationDTO substationDTO) {
        Substation substation = substationMapper.mapDTOtoSubstation(substationDTO);
        Optional<Substation> substationOptional = substationRepository.findById(id);
        if (substationOptional.isPresent()) {
            substation.setId(id);
            return substationMapper.mapSubstationToDTO(substationRepository.save(substation));    //save(substation);
        }
        else throw new EntityNotFoundException("User with id " + id + " not found");
    }

    public void deleteSubstation(Integer id) {
        Optional<Substation> substationOptional = substationRepository.findById(id);
        if (substationOptional.isPresent()) { substationRepository.deleteById(id); }
        else throw new EntityNotFoundException("User with id " + id + " not found");
    }


    public SubstationDTO createWithDTO(SubstationDTO substationDTO) {
        Substation substation = substationMapper.mapDTOtoSubstation(substationDTO);
        return substationMapper.mapSubstationToDTO(substationRepository.save(substation));
    }

    public List<SubstationDTO> findByName(String searchTerm){
        Optional<List<Substation>> substationList = substationRepository.findByNameContaining(searchTerm);
        if(substationList.isPresent()){
             return substationList.get()
                    .stream()
                    .map(substationMapper::mapSubstationToDTO)
                    .collect(Collectors.toList());
        }
        else throw new EntityNotFoundException("No substations with "+ searchTerm + " name found");
    }

    public List<SubstationDTO> filterByVoltage(String hvlv) {
        Optional<List<Substation>> substationList = substationRepository
                .findByVoltageTransformationLike(VoltageTransformation.getByVT(hvlv));
        if(substationList.isPresent()){
            return substationList.get()
                    .stream()
                    .map(substationMapper::mapSubstationToDTO)
                    .collect(Collectors.toList());
        }
        else throw new EntityNotFoundException("No substations with "+ hvlv + " name found");
    }
}


