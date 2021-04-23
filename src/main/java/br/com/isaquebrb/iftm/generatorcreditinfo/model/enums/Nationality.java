package br.com.isaquebrb.iftm.generatorcreditinfo.model.enums;

import lombok.Getter;

import java.util.Arrays;

public enum Nationality {

    GERMAN("Alemã", 30),
    CHINESE("Chinês", 42),
    BOLIVIAN("Boliviano", 22),
    ARGENTINIAN("Argentino", 21),
    BRITISH("Britânico", 32),
    BRAZILIAN("Brasileira", 10);

    Nationality(String label, Integer code) {
        this.label = label;
        this.code = code;
    }

    @Getter
    private final String label;

    @Getter
    private final Integer code;

    public static Nationality getEnumByLabel(String label){
        return Arrays.stream(values())
                .filter(v -> v.label.equals(label))
                .findFirst()
                .orElse(BRAZILIAN);
    }
}
