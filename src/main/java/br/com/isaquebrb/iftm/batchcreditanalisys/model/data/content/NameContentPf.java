package br.com.isaquebrb.iftm.batchcreditanalisys.model.data.content;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.data.info.ForeignInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class NameContentPf extends NameContent {

    @JsonProperty("sexo")
    protected String gender;

    @JsonProperty("estrangeiro")
    private ForeignInfo foreignInfo;
}
