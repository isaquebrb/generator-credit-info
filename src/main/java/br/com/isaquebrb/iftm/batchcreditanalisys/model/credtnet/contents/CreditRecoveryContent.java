package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.contents;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreditRecoveryContent {

    @JsonProperty("faixa")
    private String range;

    @JsonProperty("mensagem")
    private String message;
}
