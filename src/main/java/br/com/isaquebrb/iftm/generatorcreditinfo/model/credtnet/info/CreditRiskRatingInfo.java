package br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.info;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.content.CreditRiskRatingContent;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.CommonInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreditRiskRatingInfo extends CommonInfo {

    public CreditRiskRatingInfo(String hasInfo, CreditRiskRatingContent content) {
        super(hasInfo);
        this.content = content;
    }

    @JsonProperty("conteudo")
    private CreditRiskRatingContent content;
}
