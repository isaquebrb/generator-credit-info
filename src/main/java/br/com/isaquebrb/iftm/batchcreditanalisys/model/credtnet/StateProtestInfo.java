package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StateProtestInfo extends CommonInfo {

    public StateProtestInfo(String hasInfo, StateProtestContent content, Integer quantity) {
        super(hasInfo);
        this.content = content;
        this.quantity = quantity;
    }

    @JsonProperty("conteudo")
    private StateProtestContent content;

    @JsonProperty("quantidade")
    private Integer quantity;

}
