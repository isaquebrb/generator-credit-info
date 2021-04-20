package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.contents;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Protest {

    @JsonProperty("data_ocorrencia")
    private String date;

    @JsonProperty("valor")
    private String value;

    @JsonProperty("cartorio")
    private String registryOffice;

    @JsonProperty("cidade")
    private String city;

    @JsonProperty("uf")
    private String state;

    @JsonProperty("tipo_anotacao")
    private String typeAnnotion;
}
