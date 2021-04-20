package br.com.isaquebrb.iftm.batchcreditanalisys.model.enums;

import lombok.Getter;

@Getter
public enum CreditRecoveryRange {

    LOWEST("BAIXISSIMO"),
    LOW("BAIXO"),
    MEDIAN("MEDIANO"),
    HIGH("ALTO"),
    HIGHEST("ALTISSIMO");

    CreditRecoveryRange(String label) {
        this.label = label;
    }

    private String label;
}
