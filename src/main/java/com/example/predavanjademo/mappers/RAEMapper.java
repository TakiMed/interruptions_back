package com.example.predavanjademo.mappers;

import com.example.predavanjademo.enums.Type2;
import com.example.predavanjademo.web.dto.InterruptionDTO;
import com.example.predavanjademo.web.dto.InterruptionRAEDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class RAEMapper {

    public static List<InterruptionRAEDTO> mapToRAE(InterruptionDTO interruptionDTO){
        List<InterruptionRAEDTO> RAEList = new ArrayList<>();
        Long tb =  interruptionDTO.getDurationBefore();
        Long ta = interruptionDTO.getDurationAfter();
        Long tu = interruptionDTO.getDurationUnplanned();
        Long tp = interruptionDTO.getDurationPlanned();
        if(tp!=0){
            Date start = interruptionDTO.getPlanBeginning();
            Date end = new Date(start.getTime() + tp*60000);
            System.out.println(end);
            RAEList.add(new InterruptionRAEDTO(
                    start, start,
                    end, end,
                    Type2.planiran, tp,
                    interruptionDTO.getNumberOfCustomers(),
                    interruptionDTO.getCauseObject(),
                    interruptionDTO.getCable()));
        }
        if(tb!=0)
        {
            Date start = interruptionDTO.getRealizationBeginning();
            Date end = interruptionDTO.getPlanBeginning();
            RAEList.add(new InterruptionRAEDTO(
                    start, start,
                    end, end,
                    Type2.neplaniran, tb,
                    interruptionDTO.getNumberOfCustomers(),
                    interruptionDTO.getCauseObject(),
                    interruptionDTO.getCable()));
        }
        if(ta!=0)
        {
            Date start = interruptionDTO.getPlanEnd();
            Date end = interruptionDTO.getRealizationEnd();
            RAEList.add(new InterruptionRAEDTO(
                    start, start,
                    end, end,
                    Type2.neplaniran, ta,
                    interruptionDTO.getNumberOfCustomers(),
                    interruptionDTO.getCauseObject(),
                    interruptionDTO.getCable()));

        }
        if(tu!=0)
        {
            Date start = interruptionDTO.getRealizationBeginning();
            Date end = new Date(start.getTime() + tu*60000);
            RAEList.add(new InterruptionRAEDTO(
                    start, start,
                    end, end,
                    Type2.neplaniran, tu,
                    interruptionDTO.getNumberOfCustomers(),
                    interruptionDTO.getCauseObject(),
                    interruptionDTO.getCable()));
        }
        return RAEList;
    }

}
