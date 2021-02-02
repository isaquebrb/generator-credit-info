package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ScoreSerasaInfo extends CommonInfo {

    @JsonProperty("conteudo")
    private ScoreSerasaContent content;
}
