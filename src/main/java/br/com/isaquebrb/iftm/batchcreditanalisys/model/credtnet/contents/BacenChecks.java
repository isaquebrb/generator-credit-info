package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.contents;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BacenChecks {

    @JsonProperty("data_ocorrencia")
    private String date;

    @JsonProperty("numero_cheque")
    private String checkNumber;

    @JsonProperty("alinea_cheque")
    private String checkSubheading;

    @JsonProperty("valor")
    private String value;

    @JsonProperty("numero_banco")
    private String bankNumber;

    @JsonProperty("nome_banco")
    private String bankName;

    @JsonProperty("agencia")
    private String bankAgency;

    @JsonProperty("cidade")
    private String city;

    @JsonProperty("uf")
    @JsonAlias("state")
    private String state;
}
