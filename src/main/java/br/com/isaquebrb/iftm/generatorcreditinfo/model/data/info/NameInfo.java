package br.com.isaquebrb.iftm.generatorcreditinfo.model.data.info;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.CommonInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.content.NameContent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class NameInfo extends CommonInfo {

    public NameInfo(String hasInfo, NameContent content){
        super(hasInfo);
        this.content = content;
    }

    @JsonProperty("conteudo")
    private NameContent content;
}
