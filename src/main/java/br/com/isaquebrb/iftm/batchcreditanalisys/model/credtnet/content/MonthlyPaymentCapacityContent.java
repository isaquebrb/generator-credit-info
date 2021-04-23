package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MonthlyPaymentCapacityContent {

    @JsonProperty("valor")
    private String value;
}
