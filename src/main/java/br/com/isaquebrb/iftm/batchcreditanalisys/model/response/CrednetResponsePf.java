package br.com.isaquebrb.iftm.batchcreditanalisys.model.response;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.CrednetInfoPf;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CrednetResponsePf {

    @JsonProperty("content")
    private CrednetInfoPf crednetInfoPf;

    private String date;

    private String hour;
}
