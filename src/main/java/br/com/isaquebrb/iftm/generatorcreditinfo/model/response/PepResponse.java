package br.com.isaquebrb.iftm.generatorcreditinfo.model.response;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.pep.PepInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PepResponse {

    @JsonProperty("content")
    private PepInfo pepInfo;

    private String date;

    private String hour;
}
