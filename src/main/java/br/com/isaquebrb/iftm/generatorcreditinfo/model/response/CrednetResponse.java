package br.com.isaquebrb.iftm.generatorcreditinfo.model.response;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.CrednetInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CrednetResponse {

    @JsonProperty("content")
    private CrednetInfo crednetInfo;

    private String date;

    private String hour;
}
