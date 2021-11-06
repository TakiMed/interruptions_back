package com.example.predavanjademo.converters;

import com.example.predavanjademo.enums.City;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CityConverter implements AttributeConverter<City, String> {


    @Override
    public String convertToDatabaseColumn(City city) {
        return city.getNumVal();
    }

    @Override
    public City convertToEntityAttribute(String s) {
        return City.getByVT(s);
    }
}
