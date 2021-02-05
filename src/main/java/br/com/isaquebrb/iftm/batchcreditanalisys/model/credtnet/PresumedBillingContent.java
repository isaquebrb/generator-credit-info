package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class PresumedBillingContent {

    @JsonProperty("mensagem")
    private String message;

    @JsonProperty("valor")
    private String value;
}
