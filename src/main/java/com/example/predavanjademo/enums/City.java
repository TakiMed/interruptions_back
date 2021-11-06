package com.example.predavanjademo.enums;

import java.util.Arrays;

public enum City {
    NIKŠIĆ("NIKŠIĆ"),
    PODGORICA("PODGORICA"), CETINJE("CETINJE"),
    BERANE("BERANE"), ROŽAJE("ROŽAJE"),
    BUDVA("BUDVA"), BAR("BAR"), ULCINJ("ULCINJ"),
    KOTOR("KOTOR"), TIVAT("TIVAT"), HERCEGNOVI("HERCEG NOVI"),
    BIJELOPOLJE("BIJELO POLJE"), KOLAŠIN("KOLAŠIN"), MOJKOVAC("MOJKOVAC"),
    ŽABLJAK("ŽABLJAK"), PLJEVLJA("PLJEVLJA");


    private String numVal;
    public String getNumVal() {
        return numVal;
    }

    City(String numVal) {
        this.numVal = numVal;
    }

    public static City getByVT(String getString) {
        City city = Arrays.stream(City.values())
                .filter(val -> val.getNumVal().equals(getString))
                // .map(val -> val.getNumVal())
                .findFirst()
                .orElse(null);
        return city;
    }
}
