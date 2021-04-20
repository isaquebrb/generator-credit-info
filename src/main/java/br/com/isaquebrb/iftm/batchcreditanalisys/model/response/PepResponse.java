package br.com.isaquebrb.iftm.batchcreditanalisys.model.response;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.pep.PepInfo;
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
