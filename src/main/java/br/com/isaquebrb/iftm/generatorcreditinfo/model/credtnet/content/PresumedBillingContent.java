package br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PresumedBillingContent {

    @JsonProperty("mensagem")
    private String message;

    @JsonProperty("valor")
    private String value;
}
