package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CommonInfo {

    @JsonProperty("existe_informacao")
    private String hasInformation;

}
