package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.info;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.CommonInfo;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.contents.DeathContent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class DeathInfo extends CommonInfo {

    public DeathInfo(String hasInfo, DeathContent content) {
        super(hasInfo);
        this.content = content;
    }

    @JsonProperty("conteudo")
    private DeathContent content;
}
