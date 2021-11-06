package com.example.predavanjademo.web.dto;
import com.example.predavanjademo.enums.City;
import com.example.predavanjademo.enums.Region;
import com.example.predavanjademo.enums.VoltageTransformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SubstationDTO {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubstationDTO.class);

    private Integer id;

    // @NotNull
    // @Size(min=2,max=2) a onda u kontroleru @Valid
    private Region region;

    private City city;

    private String municipality;

    private String voltageTransformation;

    private String issCode;

    private String name;

    private String fullName;

    public SubstationDTO(){}

    public SubstationDTO(Integer id,
                         Region region, City city, String municipality,
                         String voltageTransformation, String issCode,
                         String name,
                         String fullName) {
        this.id = id;
        this.region = region;
        this.city = city;
        this.municipality = municipality;
        this.voltageTransformation = voltageTransformation;
        this.issCode = issCode;
        this.name = name;
        this.fullName = fullName;
    }

    public SubstationDTO(
                         Region region, City city, String municipality,
                         String voltageTransformation, String issCode,
                         String name,
                         String fullName) {
        this.region = region;
        this.city = city;
        this.municipality = municipality;
        this.voltageTransformation = voltageTransformation;
        this.issCode = issCode;
        this.name = name;
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getVoltageTransformation() {
        return voltageTransformation;
    }

    public void setVoltageTransformation(String voltageTransformation) {
        this.voltageTransformation = voltageTransformation;
    }

    public String getIssCode() {
        return issCode;
    }

    public void setIssCode(String issCode) {
        this.issCode = issCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        LOGGER.info("USING SETTER IN FULL NAME SUB DTO CLASS");
        this.fullName = this.voltageTransformation + " " + this.name;
    }

    @Override
    public String toString() {
        return "SubstationDTO{" +
                "id=" + id +
                ", region=" + region +
                ", city=" + city +
                ", municipality='" + municipality + '\'' +
                ", voltageTransformation='" + voltageTransformation + '\'' +
                ", issCode='" + issCode + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
