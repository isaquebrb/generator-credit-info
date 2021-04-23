package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.info;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.CommonInfo;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.content.MonthlyPaymentCapacityContent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MonthlyPaymentCapacityInfo extends CommonInfo {

    public MonthlyPaymentCapacityInfo(String hasInfo, MonthlyPaymentCapacityContent content){
        super(hasInfo);
        this.content = content;
    }

    @JsonProperty("conteudo")
    private MonthlyPaymentCapacityContent content;
}
