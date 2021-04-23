package br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.info;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.CommonInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.content.CreditRecoveryContent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreditRecoveryInfo extends CommonInfo {

    public CreditRecoveryInfo(String hasInfo, CreditRecoveryContent content) {
        super(hasInfo);
        this.content = content;
    }

    @JsonProperty("conteudo")
    private CreditRecoveryContent content;
}
