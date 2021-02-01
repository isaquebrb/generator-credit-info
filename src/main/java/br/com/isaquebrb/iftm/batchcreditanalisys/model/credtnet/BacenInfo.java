package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class BacenInfo extends CommonInfo{

    @JsonProperty("quantidade")
    private Integer quantity;

    @JsonProperty("conteudo")
    private BacenContent content;
}
