package com.example.predavanjademo.converters;

import com.example.predavanjademo.enums.VoltageLevel;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class VoltageLevelConverter implements AttributeConverter<VoltageLevel, String> {
    @Override
    public String convertToDatabaseColumn(VoltageLevel voltageLevel) {
        return voltageLevel.getNumVal();
    }

    @Override
    public VoltageLevel convertToEntityAttribute(String s) {
        return VoltageLevel.getByVT(s);
    }
}
