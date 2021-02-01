package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class FinancialPendenciesContent {

    @JsonProperty("detalhes")
    private List<FinancialPendenciesDetail> details;
}
