package br.com.isaquebrb.iftm.batchcreditanalisys.model.data.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OriginCountryInfo {

    @JsonProperty("codigo")
    private String code;

    @JsonProperty("origem")
    private String origin;
}
