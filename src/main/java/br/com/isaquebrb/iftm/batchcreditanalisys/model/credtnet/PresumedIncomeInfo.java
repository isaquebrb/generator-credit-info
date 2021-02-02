package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PresumedIncomeInfo extends CommonInfo{

    @JsonProperty("conteudo")
    private PersumedIncomeContent content;
}
