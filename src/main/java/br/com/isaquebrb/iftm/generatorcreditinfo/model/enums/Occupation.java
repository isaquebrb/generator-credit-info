package br.com.isaquebrb.iftm.generatorcreditinfo.model.enums;

import lombok.Getter;


public enum Occupation {

    PRESIDENT("PRESIDENTE"),
    GOVERNOR("GOVERNADOR"),
    MAYOR("PREFEITO"),
    CONGRESSMAN("DEPUTADO");

    Occupation(String label){
        this.label = label;
    }

    @Getter
    private final String label;
}
