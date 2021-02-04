package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeathInfo extends CommonInfo {

    public DeathInfo(String hasInfo, DeathContent content){
        super(hasInfo);
        this.content = content;
    }

    @JsonProperty("conteudo")
    private DeathContent content;
}
