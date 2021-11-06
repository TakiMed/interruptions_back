package com.example.predavanjademo.mappers;

import com.example.predavanjademo.entities.Substation;
import com.example.predavanjademo.enums.VoltageTransformation;
import com.example.predavanjademo.web.dto.SubstationDTO;
import org.springframework.stereotype.Component;

@Component
public class SubstationMapper {
    public SubstationDTO mapSubstationToDTO(Substation substation){
        return new SubstationDTO(
                substation.getId(),
                substation.getRegion(),
                substation.getCity(),
                substation.getMunicipality(),
                substation.getVoltageTransformation().getNumVal(),
                substation.getIssCode(),
                substation.getName(),
                substation.getFullName()
        );
    }

    public Substation mapDTOtoSubstation(SubstationDTO substationDTO){
        return new Substation(
                substationDTO.getId(),
                substationDTO.getRegion(),
                substationDTO.getCity(),
                substationDTO.getMunicipality(),
                VoltageTransformation.getByVT(substationDTO.getVoltageTransformation()),
                substationDTO.getIssCode(),
                substationDTO.getName(),
                substationDTO.getFullName()
        );
    }

}
