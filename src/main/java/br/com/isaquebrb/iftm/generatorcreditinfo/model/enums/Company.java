package br.com.isaquebrb.iftm.generatorcreditinfo.model.enums;

import lombok.Getter;

@Getter
public enum Company {

    COMPANY_1("EMBALAGENS LTDA", "AVELAR EMBALAGENS", 46869, "COMÉRCIO ATACADISTA DE PAPEL E PAPELÃO EM BRUTO E DE EMBALAGENS"),
    COMPANY_2("PANIFICADORA LTDA", "PADARIA POR DO SOL", 47211, "COMÉRCIO VAREJISTA DE PRODUTOS DE PADARIA, LATICÍNIO, DOCES, BALAS E SEMELHANTES"),
    COMPANY_3("SOFTWARES S/A", "SFW SISTEMAS", 6201501, "DESENVOLVIMENTO DE PROGRAMAS DE COMPUTADOR SOB ENCOMENDA"),
    COMPANY_4("SUPERMERCADO LTDA", "MERCADINHO 5 ESTRELAS", 47113, "COMÉRCIO VAREJISTA DE MERCADORIAS EM GERAL, COM PREDOMINÂNCIA DE PRODUTOS ALIMENTÍCIOS - SUPERMERCADOS"),
    COMPANY_5("BARBEARIA LTDA", "BARBER CHOPP", 9602501, "SERVIÇOS DE CABELEIREIRO");

    Company(String label, String tradeName, Integer cnae, String descriptionCnae) {
        this.label = label;
        this.tradeName = tradeName;
        this.cnae = cnae;
        this.descriptionCnae = descriptionCnae;
    }

    private final String label;
    private final String tradeName;
    private final Integer cnae;
    private final String descriptionCnae;


}
