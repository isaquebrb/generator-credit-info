package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.info;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.CommonInfo;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.content.CreditRecoveryContent;
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
