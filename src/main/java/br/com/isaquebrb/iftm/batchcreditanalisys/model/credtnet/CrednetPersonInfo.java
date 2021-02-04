package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CrednetPersonInfo extends CommonInfo {

    public CrednetPersonInfo(String hasInfo, CrednetPersonContent content) {
        super(hasInfo);
        this.content = content;
    }

    @JsonProperty("conteudo")
    private CrednetPersonContent content;
}
