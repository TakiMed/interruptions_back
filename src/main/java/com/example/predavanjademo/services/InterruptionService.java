package com.example.predavanjademo.services;

import com.example.predavanjademo.entities.Interruption;
import com.example.predavanjademo.enums.VoltageLevel;
// import com.example.predavanjademo.mappers.CreateInterruptionMapper;
import com.example.predavanjademo.mappers.CreateInterruptionMapper;
import com.example.predavanjademo.mappers.InterruptionMapper;
import com.example.predavanjademo.mappers.RAEMapper;
import com.example.predavanjademo.repositories.InterruptionRepository;
import com.example.predavanjademo.web.dto.CreateInterruptionDTO;
import com.example.predavanjademo.web.dto.GetSubstationDTO;
import com.example.predavanjademo.web.dto.InterruptionDTO;
import com.example.predavanjademo.web.dto.InterruptionRAEDTO;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class InterruptionService {
    @Autowired
    private InterruptionRepository interruptionRepository;
    @Autowired
    private CreateInterruptionMapper createInterruptionMapper;
    @Autowired
    private InterruptionMapper interruptionMapper;
    @Autowired
    private RAEMapper raeMapper;


    public List<InterruptionDTO> findByDTOs()
    {
        return interruptionRepository.findAll()
                .stream()
                .map(interruptionMapper::mapInterruptionToDTO)
                .collect(Collectors.toList());
    }


    public List<Interruption> findAll() {
        return interruptionRepository.findAll();
    }

    public List<Interruption> findByVoltageLevel(String voltageLevel){
        return interruptionRepository.getByVoltageLevel(VoltageLevel.getByVT(voltageLevel));
    }

    public InterruptionDTO createWithDTO(CreateInterruptionDTO interruptionDTO) {
        Interruption interruption = createInterruptionMapper.mapDTOToInterruption(interruptionDTO);
        return interruptionMapper.mapInterruptionToDTO(interruptionRepository.save(interruption));
    }

    public InterruptionDTO findWithDTOById(Integer id) throws EntityNotFoundException  {
        Optional<Interruption> interruption = interruptionRepository.findById(id);
        if(interruption.isPresent())
            return this.interruptionMapper.mapInterruptionToDTO(interruption.get());
        else throw new EntityNotFoundException("No Interruption with id  " +  id + " stored in DB.") ;
    }

    public Map<Integer, List<InterruptionRAEDTO>> getRAEInterruptionMap(){
        List<InterruptionDTO> interruptionDTOList = this.findByDTOs();
        Map<Integer, List<InterruptionRAEDTO>> RAEMap = new HashMap<>();
        for(InterruptionDTO iDTO : interruptionDTOList){
            RAEMap.put(iDTO.getInterruptionNumber(), raeMapper.mapToRAE(iDTO));
        }
        System.out.println(RAEMap.values().toString());
        return RAEMap;
    }

    public List<InterruptionRAEDTO> getRAEList(){
        Map<Integer, List<InterruptionRAEDTO>> RAEmap = this.getRAEInterruptionMap();
        List<InterruptionRAEDTO> RAEList =  new ArrayList<>();
        RAEList = RAEmap.values()
                .stream().flatMap(Collection::stream).collect(Collectors.toList());
        return RAEList;
    }


    public void deleteById(Integer id) {
        this.interruptionRepository.deleteById(id);
    }
}
