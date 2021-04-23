package br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.info;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.CommonInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.content.StateProtestContent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
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
