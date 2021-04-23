package br.com.isaquebrb.iftm.batchcreditanalisys.model.data.info;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.CommonInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ForeignInfo extends CommonInfo {

    @JsonProperty("estrangeiro")
    private String foreign;

    @JsonProperty("pais_origem")
    private OriginCountryInfo originCountryInfo;
}
