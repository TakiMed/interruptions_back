package com.example.predavanjademo.enums;

import com.example.predavanjademo.entities.Substation;
import com.sun.media.jfxmedia.logging.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.Arrays;

public enum VoltageTransformation {
    EH("110/35"), EK("110/10"), EX("110/X"),
    HH("35/35"), HJ("35/0,4"), HK("35/10"),
    HL("35/6"), HM("35/0,69"),
    HO("35/6,3"), KN("10/0,4"), LN("6/0,4");

    private String numVal;

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(VoltageTransformation.class);

    VoltageTransformation(String numVal) {
        this.numVal = numVal;
    }

    public String getNumVal() {
        return numVal;
    }

    public void setNumVal(String numVal) {
        this.numVal = numVal;
    }

    public static VoltageTransformation getByVT(String voltageTransformationString) {
        VoltageTransformation voltageTransformation = Arrays.stream(VoltageTransformation.values())
                .filter(val -> val.getNumVal().equals(voltageTransformationString))
                .findFirst()
                .orElse(null);
        return voltageTransformation;
    }

}
