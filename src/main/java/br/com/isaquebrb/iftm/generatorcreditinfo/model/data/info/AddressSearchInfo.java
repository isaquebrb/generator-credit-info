package br.com.isaquebrb.iftm.generatorcreditinfo.model.data.info;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.CommonInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.content.AddressSearchContent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class AddressSearchInfo extends CommonInfo {

    public AddressSearchInfo(String hasInfo, List<AddressSearchContent> content) {
        super(hasInfo);
        this.content = content;
    }

    @JsonProperty("conteudo")
    private List<AddressSearchContent> content;
}
