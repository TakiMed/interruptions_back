package com.example.predavanjademo.web.dto;

import com.example.predavanjademo.enums.Type1;
import com.example.predavanjademo.enums.VoltageLevel;

public class GetInterruptionDTO {

    private com.example.predavanjademo.enums.VoltageLevel VoltageLevel;

    private Integer interruptionNumber;

    private GetSubstationDTO getSubstationDTO;

    private Integer numberOfCustomers;

    private Type1 type1;

    public GetInterruptionDTO(VoltageLevel voltageLevel, Integer interruptionNumber, GetSubstationDTO getSubstationDTO, Integer numberOfCustomers, Type1 type1) {
        VoltageLevel = voltageLevel;
        this.interruptionNumber = interruptionNumber;
        this.getSubstationDTO = getSubstationDTO;
        this.numberOfCustomers = numberOfCustomers;
        this.type1 = type1;
    }

    public VoltageLevel getVoltageLevel() {
        return VoltageLevel;
    }

    public void setVoltageLevel(VoltageLevel voltageLevel) {
        VoltageLevel = voltageLevel;
    }

    public Integer getInterruptionNumber() {
        return interruptionNumber;
    }

    public void setInterruptionNumber(Integer interruptionNumber) {
        this.interruptionNumber = interruptionNumber;
    }

    public GetSubstationDTO getGetSubstationDTO() {
        return getSubstationDTO;
    }

    public void setGetSubstationDTO(GetSubstationDTO getSubstationDTO) {
        this.getSubstationDTO = getSubstationDTO;
    }

    public Integer getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(Integer numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

    public Type1 getType1() {
        return type1;
    }

    public void setType1(Type1 type1) {
        this.type1 = type1;
    }
}
