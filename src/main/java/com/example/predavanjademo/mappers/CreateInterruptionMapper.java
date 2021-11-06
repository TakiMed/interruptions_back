package com.example.predavanjademo.mappers;

import com.example.predavanjademo.entities.Interruption;
import com.example.predavanjademo.entities.Substation;
import com.example.predavanjademo.enums.Type1;
import com.example.predavanjademo.enums.Type2;
import com.example.predavanjademo.enums.VoltageLevel;
import com.example.predavanjademo.services.SubstationService;
import com.example.predavanjademo.web.dto.CreateInterruptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class CreateInterruptionMapper {

    @Autowired
    private SubstationService substationService;

    public Interruption mapDTOToInterruption(CreateInterruptionDTO createInDTO){
        System.out.println(createInDTO.getSubstation());

        Substation substation = substationService.getSubstationByName(createInDTO.getSubstation());
        Type1 type1 = Type1.getByVT(createInDTO.getType1());

        Interruption interrupt =  new Interruption(
                VoltageLevel.getByVT(createInDTO.getVoltageLevel()),
                createInDTO.getInterruptionNumber(),
                substation,
                createInDTO.getNumberOfCustomers(),
                type1,
                type2fun(type1.getVal()),
                createInDTO.getType3(),
                createInDTO.getType4(),
                createInDTO.getFailureObject(),
                createInDTO.getFailureProtection(),
                createInDTO.getCauseObject(),
                createInDTO.getCable(),
                createInDTO.getDescription(),
                createInDTO.getDispatch(),
                createInDTO.getPlanBeginning(),
                createInDTO.getPlanEnd(),
                createInDTO.getRealizationBeginning(),
                createInDTO.getRealizationEnd(),
                timingFun(createInDTO).get("tBefore"),
                timingFun(createInDTO).get("tAfter"),
                timingFun(createInDTO).get("tPlanned"),
                timingFun(createInDTO).get("tUnplanned"),
                timingFun(createInDTO).get("duration")
        );
        return interrupt;
    }
    private Type2 type2fun(String type1Str){
        return type1Str.equals("NAJAVLJEN") ? Type2.planiran : Type2.neplaniran;
    }

    private Map<String, Long> timingFun(CreateInterruptionDTO createInterruptionDTO){
        Date planStart = createInterruptionDTO.getPlanBeginning();
        Date planEnd = createInterruptionDTO.getPlanEnd();
        Date realStart = createInterruptionDTO.getRealizationBeginning();
        Date realEnd = createInterruptionDTO.getRealizationEnd();
        Integer divisionCONST = 60000;

       Long tBefore = planStart.getTime() >= realStart.getTime()
               ? planStart.getTime() - realStart.getTime()
               : 0;


       Long tAfter = realEnd.getTime() >= planEnd.getTime() && realStart.getTime()< planEnd.getTime()
                ? realEnd.getTime() - planEnd.getTime()
                : 0;


       Long tPlanned  = realEnd.getTime()<= planEnd.getTime() && planStart.getTime() > realStart.getTime()
               ? realEnd.getTime() - planStart.getTime()
               : planEnd.getTime() - planStart.getTime();

       Long tUnplanned = (planEnd.getTime() - planStart.getTime() == 0 && realStart.getTime()>= planEnd.getTime())
               ? realEnd.getTime() - realStart.getTime()
               : 0;

       Long duration = realEnd.getTime() - realStart.getTime();

        Map<String, Long> times = new HashMap<>();
        times.put("tBefore", tBefore/divisionCONST);
        times.put("tAfter", tAfter/divisionCONST);
        times.put("tPlanned", tPlanned/divisionCONST);
        times.put("tUnplanned", tUnplanned/divisionCONST);
        times.put("duration", duration/divisionCONST);
        return times;
    }


}
