package br.com.isaquebrb.iftm.batchcreditanalisys.model.data.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class NameContent {

    @JsonProperty("documento")
    protected String document;

    @JsonProperty("tipo_documento")
    protected String documentType;

    @JsonProperty("nome")
    protected String name;

    @JsonProperty("data_nascimento")
    protected String birthdayDate;

    @JsonProperty("idade")
    protected String age;
}
