package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.contents;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FinancialPendenciesContent {

    @JsonProperty("detalhes")
    private List<FinancialPendenciesDetail> detailList;
}
