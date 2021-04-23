package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Pendencies {

    @JsonProperty("data_ocorrencia")
    private String date;

    @JsonProperty("modalidade")
    private String modality;

    @JsonProperty("avalista")
    private String guarantor;

    @JsonProperty("valor")
    private String value;

    @JsonProperty("contrato")
    private String contract;

    @JsonProperty("origem")
    private String origin;

    @JsonProperty("tipo_anotacao")
    private String typeAnnotation;
}
