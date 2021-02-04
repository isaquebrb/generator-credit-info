package br.com.isaquebrb.iftm.batchcreditanalisys.model.response;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.CrednetInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProcobCrednetResponse {

    @JsonProperty("content")
    private CrednetInfo crednetInfo;

    private String date;

    private String hour;
}
