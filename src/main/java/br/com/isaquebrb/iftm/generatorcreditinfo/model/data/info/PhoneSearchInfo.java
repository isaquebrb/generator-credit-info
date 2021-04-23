package br.com.isaquebrb.iftm.generatorcreditinfo.model.data.info;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.CommonInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.content.PhoneSearchContent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PhoneSearchInfo extends CommonInfo {

    public PhoneSearchInfo(String hasInfo, PhoneSearchContent content) {
        super(hasInfo);
        this.content = content;
    }

    @JsonProperty("conteudo")
    private PhoneSearchContent content;
}
