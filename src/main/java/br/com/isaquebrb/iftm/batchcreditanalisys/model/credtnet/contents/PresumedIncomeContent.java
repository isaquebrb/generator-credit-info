package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.contents;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PresumedIncomeContent {

    @JsonProperty("renda")
    private String income;
}
