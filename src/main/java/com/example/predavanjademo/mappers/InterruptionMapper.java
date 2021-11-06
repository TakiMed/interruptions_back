package com.example.predavanjademo.mappers;

import com.example.predavanjademo.entities.Interruption;
import com.example.predavanjademo.entities.Substation;
import com.example.predavanjademo.services.SubstationService;
import com.example.predavanjademo.web.dto.GetSubstationDTO;
import com.example.predavanjademo.web.dto.InterruptionDTO;
import com.example.predavanjademo.web.dto.SubstationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InterruptionMapper {

    @Autowired
    private SubstationService substationService;


    public InterruptionDTO mapInterruptionToDTO(Interruption interruption) {

        return new InterruptionDTO(
                interruption.getId(),
                interruption.getVoltageLevel().getNumVal(),
                interruption.getInterruptionNumber(),
                interruption.getSubstation().getFullName(),
                interruption.getNumberOfCustomers(),
                interruption.getType1().getVal(),
                interruption.getType2(),
                interruption.getType3(),
                interruption.getType4(),
                interruption.getFailureObject(),
                interruption.getFailureProtection(),
                interruption.getCauseObject(),
                interruption.getCable(),
                interruption.getDescription(),
                interruption.getDispatch(),
                interruption.getPlanBeginning(),
                interruption.getPlanEnd(),
                interruption.getRealizationBeginning(),
                interruption.getRealizationEnd(),
                interruption.getDurationBefore(),
                interruption.getDurationAfter(),
                interruption.getDurationPlanned(),
                interruption.getDurationUnplanned(),
                interruption.getDuration()
        );
    }
}
