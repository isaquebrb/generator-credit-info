package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CrednetPersonInfo extends CommonInfo {

    @JsonProperty("conteudo")
    private CrednetPersonContent content;
}
