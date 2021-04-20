package br.com.isaquebrb.iftm.batchcreditanalisys.model.enums;

import lombok.Getter;

@Getter
public enum Occupation {

    PRESIDENT("PRESIDENTE"),
    GOVERNOR("GOVERNADOR"),
    MAYOR("PREFEITO"),
    CONGRESSMAN("DEPUTADO");

    Occupation(String label){
        this.label = label;
    }
    private String label;
}
