package br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.info;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.CommonInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.content.CrednetPersonContent;
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
