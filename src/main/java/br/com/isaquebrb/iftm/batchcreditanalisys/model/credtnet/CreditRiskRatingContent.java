package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreditRiskRatingContent {

    @JsonProperty("pontuacao")
    private String scorePoints;

    @JsonProperty("inadimplencia")
    private String defaultRate;

    @JsonProperty("mensagem")
    private String message;
}
