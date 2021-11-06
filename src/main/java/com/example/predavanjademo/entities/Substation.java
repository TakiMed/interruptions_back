package com.example.predavanjademo.entities;

import com.example.predavanjademo.converters.CityConverter;
import com.example.predavanjademo.converters.VoltageLevelConverter;
import com.example.predavanjademo.converters.VoltageTransformationConverter;
import com.example.predavanjademo.enums.City;
import com.example.predavanjademo.enums.Region;
import com.example.predavanjademo.enums.VoltageTransformation;
import com.example.predavanjademo.services.SubstationService;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Entity
@Table(name = "substation")
@DynamicInsert
@DynamicUpdate
public class Substation {

    private static final Logger LOGGER = LoggerFactory.getLogger(Substation.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Region region;

    @Column
    @Convert(converter = CityConverter.class)
    private City city;

    @Column
    private String municipality;


    @Column(name = "voltage")
    @Convert(converter = VoltageTransformationConverter.class)
    private VoltageTransformation voltageTransformation;

    @Column(name = "iss_code")
    private String issCode;

    @Column
    private String name;

    @Column(name = "full_name")
    private String fullName;

    public Substation() {
    }

    public Substation(Integer id, Region region, City city, String municipality,
                      VoltageTransformation voltageTransformation, String issCode,
                      String name, String fullName) {
        this.id = id;
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

    public VoltageTransformation getVoltageTransformation() {
        return voltageTransformation;
    }

    public void setVoltageTransformation(VoltageTransformation voltageTransformation) {
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
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Substation{" +
                "id=" + id +
                ", region=" + region +
                ", city=" + city +
                ", municipality='" + municipality + '\'' +
                ", voltageTransformation=" + voltageTransformation +
                ", issCode='" + issCode + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
