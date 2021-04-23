package br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FinancialPendenciesContent {

    @JsonProperty("detalhes")
    private FinancialPendenciesDetail financialPendenciesDetail;
}
