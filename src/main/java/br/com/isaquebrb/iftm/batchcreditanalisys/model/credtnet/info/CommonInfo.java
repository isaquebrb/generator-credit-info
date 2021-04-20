package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommonInfo {

    @JsonProperty("existe_informacao")
    private String hasInformation;

}
