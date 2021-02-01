package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CrednetPersonInfo extends CommonInfo {

    @JsonProperty("conteudo")
    private CrednetPersonContent content;
}
