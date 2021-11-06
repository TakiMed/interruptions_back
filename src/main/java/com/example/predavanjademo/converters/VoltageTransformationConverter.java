package com.example.predavanjademo.converters;

import com.example.predavanjademo.enums.VoltageTransformation;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class VoltageTransformationConverter implements AttributeConverter<VoltageTransformation, String> {


    @Override
    public String convertToDatabaseColumn(VoltageTransformation voltageTransformation) {
        return voltageTransformation.getNumVal();
    }

    @Override
    public VoltageTransformation convertToEntityAttribute(String dbString) {
        return VoltageTransformation.getByVT(dbString);
    }
}
