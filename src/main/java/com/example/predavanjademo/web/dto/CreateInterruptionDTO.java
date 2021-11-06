package com.example.predavanjademo.web.dto;
import com.example.predavanjademo.entities.Substation;
import com.example.predavanjademo.enums.*;
import com.example.predavanjademo.web.controllers.InterruptionController;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateInterruptionDTO {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateInterruptionDTO.class);

    private String voltageLevel;

    private Integer interruptionNumber;

    private String substation;

    private Integer numberOfCustomers;

    private String type1;

    private Type3 type3;

    private Type4 type4;

    private String failureObject;

    private String failureProtection;

    private String causeObject;

    private Boolean cable;

    private String description;

    private String dispatch;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy hh:mm:ss")
    private Date planBeginning;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy hh:mm:ss")
    private Date planEnd;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy hh:mm:ss")
    private Date realizationBeginning;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy hh:mm:ss")
    private Date realizationEnd;


    @Override
    public String toString() {
        Long duration = (realizationEnd.getTime() - realizationBeginning.getTime())/(1000*60);
        return "CreateInterruptionDTO{" +
                "voltageLevel=" + voltageLevel +
                ", interruptionNumber=" + interruptionNumber +
                ", substation=" + substation +
                ", numberOfCustomers=" + numberOfCustomers +
                ", type1=" + type1 +
                ", type3=" + type3 +
                ", type4=" + type4 +
                ", failureObject='" + failureObject + '\'' +
                ", failureProtection='" + failureProtection + '\'' +
                ", causeObject='" + causeObject + '\'' +
                ", cable=" + cable +
                ", description='" + description + '\'' +
                ", dispatch='" + dispatch + '\'' +
                ", planBeginning=" + planBeginning +
                ", planEnd=" + planEnd +
                ", realizationBeginning=" + realizationBeginning +
              ", realizationEnd=" + realizationEnd +
                ", duration='" + duration + '\'' +
                '}';
    }
}
