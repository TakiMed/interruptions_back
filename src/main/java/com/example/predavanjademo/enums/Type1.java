package com.example.predavanjademo.enums;

import java.util.Arrays;

public enum Type1 {
    A("NAJAVLJEN"), B("NENAJAVLJEN"), C("NAJAVLJEN<24");

    private String val;

    public String getVal() {
        return val;
    }

    private Type1 (String val) {
        this.val = val;
    }

    public static Type1  getByVT(String getString) {
        Type1 type1 = Arrays.stream(Type1 .values())
                .filter(val -> val.getVal().equals(getString))
                // .map(val -> val.getNumVal())
                .findFirst()
                .orElse(null);
        return type1;
    }

}
