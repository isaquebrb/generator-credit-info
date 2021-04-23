package br.com.isaquebrb.iftm.generatorcreditinfo.model.data.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class NameContentPf extends NameContent {

    @JsonProperty("sexo")
    protected String gender;

    @JsonProperty("estrangeiro")
    private Foreign foreign;
}
