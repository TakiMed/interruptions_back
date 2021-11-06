package com.example.predavanjademo.mappers;
import com.example.predavanjademo.entities.Substation;
import com.example.predavanjademo.enums.VoltageTransformation;
import com.example.predavanjademo.web.dto.SubstationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ISubstationMapper {

    public SubstationDTO mapSubstationToDTO(Substation substation);

    public Substation mapDTOtoSubstation(SubstationDTO substationDTO);

    @Named("customVoltageTransformationMapping")
    default String customVoltageTransformationMapping(VoltageTransformation voltageTransformation){
        return "HK"; // switch cases
    }

}
