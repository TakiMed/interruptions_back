package com.example.predavanjademo.enums;

import java.util.Arrays;


public enum VoltageLevel {
        H("35"), K("10"), L("0,4");

        private String numVal;

        private VoltageLevel(String numVal) {
            this.numVal = numVal;
        }

    public String getNumVal() {
        return numVal;
    }

    public void setNumVal(String numVal) {
        this.numVal = numVal;
    }

    public static VoltageLevel getByVT(String s) {
        VoltageLevel voltageLevel = Arrays.stream(VoltageLevel.values())
                .filter(val -> val.getNumVal().equals(s))
                .findFirst()
                .orElse(null);
        return voltageLevel;
    }
}
