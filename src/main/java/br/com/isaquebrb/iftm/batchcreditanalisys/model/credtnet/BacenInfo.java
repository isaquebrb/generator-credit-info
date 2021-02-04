package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BacenInfo extends CommonInfo {

    public BacenInfo(String hasInfo, BacenContent content, Integer quantity) {
        super(hasInfo);
        this.content = content;
        this.quantity = quantity;
    }

    @JsonProperty("quantidade")
    private Integer quantity;

    @JsonProperty("conteudo")
    private BacenContent content;
}
