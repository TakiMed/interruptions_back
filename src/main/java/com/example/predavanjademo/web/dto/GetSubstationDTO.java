package com.example.predavanjademo.web.dto;

import com.example.predavanjademo.enums.City;

public class GetSubstationDTO {

    private City city;
    private String fullName;

    public GetSubstationDTO(City city, String fullName) {
        this.city = city;
        this.fullName = fullName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
