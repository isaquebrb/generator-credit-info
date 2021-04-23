package br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CrednetPersonContent {

    @JsonProperty("nome_razao")
    private String name;

    @JsonProperty("data_nascimento_fundacao")
    private String birthDate;

    @JsonProperty("situacao_documento")
    private String docSituation;

    @JsonProperty("data_situacao_documento")
    private String docSituationDate;
}
