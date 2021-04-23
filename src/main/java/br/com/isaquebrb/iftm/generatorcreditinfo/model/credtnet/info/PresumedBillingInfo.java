package br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.info;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.CommonInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.content.PresumedBillingContent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PresumedBillingInfo extends CommonInfo {

    public PresumedBillingInfo(String hasInfo, PresumedBillingContent content) {
        super(hasInfo);
        this.content = content;
    }

    @JsonProperty("conteudo")
    private PresumedBillingContent content;
}
