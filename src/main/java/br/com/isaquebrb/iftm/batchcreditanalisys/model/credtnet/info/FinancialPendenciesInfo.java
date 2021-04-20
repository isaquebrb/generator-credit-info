package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.info;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.CommonInfo;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.contents.FinancialPendenciesContent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class FinancialPendenciesInfo extends CommonInfo {

    public FinancialPendenciesInfo(String hasInfo, FinancialPendenciesContent content, Integer quantity) {
        super(hasInfo);
        this.content = content;
        this.quantity = quantity;
    }

    @JsonProperty("quantidade")
    private Integer quantity;

    @JsonProperty("conteudo")
    private FinancialPendenciesContent content;
}
