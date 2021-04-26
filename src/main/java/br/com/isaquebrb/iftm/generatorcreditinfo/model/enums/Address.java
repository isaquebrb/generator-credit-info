package br.com.isaquebrb.iftm.generatorcreditinfo.model.enums;

import lombok.Getter;

@Getter
public enum Address {

    UBERLANDIA("MG","38407661","ALAMEDA DOS MANDARINS", "GRAND VILLE"),
    SAO_PAULO("SP","02013001","RUA DR. CÉSAR", "SANTANA"),
    PORTO_ALEGRE("RS","90670040","RUA LA PLATA", "JARDIM BOTÂNICO"),
    SALVADOR("BA","40070200","RUA DO SALETE", "BARRIS"),
    BRASILIA("DF","70757090","RUA ASA NORTE SUPERQUADRA NORTE", "ASA NORTE"),
    CURITIBA("PR","82590300","RUA CEL JOAQUIM LACERDA", "JARDIM DAS AMÉRICAS"),
    RIO_BRANCO("AC","69900634","RUA MILTON MATOS", "BOSQUE");

    Address(String uf, String cep, String street, String district){
        this.uf = uf;
        this.cep = cep;
        this.street = street;
        this.district = district;
    }

    private String uf;
    private String cep;
    private String street;
    private String district;
}
