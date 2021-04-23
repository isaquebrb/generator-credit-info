package br.com.isaquebrb.iftm.batchcreditanalisys.model.data.info;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.CommonInfo;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.data.content.NameContent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class NameInfo extends CommonInfo {

    public NameInfo(String hasInfo){
        super(hasInfo);
    }

    @JsonProperty("conteudo")
    private NameContent content;
}
