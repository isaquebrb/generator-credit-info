package br.com.isaquebrb.iftm.batchcreditanalisys.model.response;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.CrednetInfoPj;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CrednetResponsePj {

    @JsonProperty("content")
    private CrednetInfoPj crednetInfoPf;

    private String date;

    private String hour;
}
