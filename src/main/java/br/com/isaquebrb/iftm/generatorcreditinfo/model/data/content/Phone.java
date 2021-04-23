package br.com.isaquebrb.iftm.generatorcreditinfo.model.data.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Phone {

    @JsonProperty("ddd")
    private String areaCode;

    @JsonProperty("telefone")
    private String phoneNumber;

    @JsonProperty("operadora")
    private String operator;
}
