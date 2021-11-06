package com.example.predavanjademo.converters;

import com.example.predavanjademo.enums.Type1;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class Type1Converter implements AttributeConverter<Type1, String> {
    @Override
    public String convertToDatabaseColumn(Type1 type1) {
        return type1.getVal();
    }

    @Override
    public Type1 convertToEntityAttribute(String s) {
        return Type1.getByVT(s);
    }
}
