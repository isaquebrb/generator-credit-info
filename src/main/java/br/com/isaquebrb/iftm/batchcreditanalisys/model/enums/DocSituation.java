package br.com.isaquebrb.iftm.batchcreditanalisys.model.enums;

import lombok.Getter;

@Getter
public enum DocSituation {

    ACTIVE("REGULAR"),
    PENDING("PENDENTE DE REGULARIZAÇÃO"),
    SUSPENDED("SUSPENSA"),
    CANCELED("CANCELADA"),
    DEAD("TITULAR FALECIDO"),
    NULL("NULA");

    DocSituation(String label) {
        this.label = label;
    }

    private String label;
}
