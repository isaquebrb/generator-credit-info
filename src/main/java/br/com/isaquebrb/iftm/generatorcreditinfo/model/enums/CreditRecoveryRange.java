package br.com.isaquebrb.iftm.generatorcreditinfo.model.enums;

import lombok.Getter;

public enum CreditRecoveryRange {

    LOWEST("BAIXISSIMO"),
    LOW("BAIXO"),
    MEDIAN("MEDIANO"),
    HIGH("ALTO"),
    HIGHEST("ALTISSIMO");

    CreditRecoveryRange(String label) {
        this.label = label;
    }

    @Getter
    private final String label;
}
