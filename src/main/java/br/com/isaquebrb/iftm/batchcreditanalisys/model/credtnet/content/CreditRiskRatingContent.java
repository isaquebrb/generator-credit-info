package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreditRiskRatingContent {

    @JsonProperty("pontuacao")
    private String scorePoints;

    @JsonProperty("inadimplencia")
    private String defaultRate;

    @JsonProperty("mensagem")
    private String message;
}
