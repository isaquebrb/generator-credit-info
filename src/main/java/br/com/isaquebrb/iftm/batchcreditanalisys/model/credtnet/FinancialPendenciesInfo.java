package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
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
