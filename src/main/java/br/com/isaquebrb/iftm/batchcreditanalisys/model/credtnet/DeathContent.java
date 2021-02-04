package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeathContent {

    @JsonProperty("mensagem")
    private String message;
}
