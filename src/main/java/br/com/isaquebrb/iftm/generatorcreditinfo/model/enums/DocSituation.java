package br.com.isaquebrb.iftm.generatorcreditinfo.model.enums;

import lombok.Getter;

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

    @Getter
    private final String label;
}
