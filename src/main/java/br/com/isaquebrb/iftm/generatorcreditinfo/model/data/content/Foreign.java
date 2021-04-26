package br.com.isaquebrb.iftm.generatorcreditinfo.model.data.content;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.CommonInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Foreign extends CommonInfo {

    public Foreign(String hasInfo, String isForeign, OriginCountry country) {
        super(hasInfo);
        this.isForeign = isForeign;
        this.originCountry = country;
    }

    @JsonProperty("estrangeiro")
    private String isForeign;

    @JsonProperty("pais_origem")
    private OriginCountry originCountry;
}
