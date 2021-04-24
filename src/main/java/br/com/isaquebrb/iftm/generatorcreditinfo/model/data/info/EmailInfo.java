package br.com.isaquebrb.iftm.generatorcreditinfo.model.data.info;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.CommonInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.content.EmailContent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class EmailInfo extends CommonInfo {

    public EmailInfo(String hasInfo, EmailContent content){
        super(hasInfo);
        this.content = content;
    }

    @JsonProperty("conteudo")
    private EmailContent content;
}
