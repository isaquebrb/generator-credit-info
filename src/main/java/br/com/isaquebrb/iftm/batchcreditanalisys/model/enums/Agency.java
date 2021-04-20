package br.com.isaquebrb.iftm.batchcreditanalisys.model.enums;

import lombok.Getter;

@Getter
public enum Agency {

    FEDERATIVE_BRAZIL("República Federativa do Brasil"),
    MINAS_GERAIS_STATE("Estado de Minas Gerais"),
    UBERLANDIA_CITY("Cidade de Uberlândia"),
    LEGISLATIVE_SP_ASSEMBLY("Assembleia Legislativa de São Paulo");

    Agency(String label){
        this.label = label;
    }

    private String label;
}
