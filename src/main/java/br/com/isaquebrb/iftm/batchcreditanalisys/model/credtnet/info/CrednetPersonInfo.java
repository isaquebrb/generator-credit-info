package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.info;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.contents.CrednetPersonContent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CrednetPersonInfo extends CommonInfo {

    public CrednetPersonInfo(String hasInfo, CrednetPersonContent content) {
        super(hasInfo);
        this.content = content;
    }

    @JsonProperty("conteudo")
    private CrednetPersonContent content;
}
