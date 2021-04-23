package br.com.isaquebrb.iftm.generatorcreditinfo.model.data.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OriginCountry {

    @JsonProperty("codigo")
    private String code;

    @JsonProperty("origem")
    private String origin;
}
