package br.com.isaquebrb.iftm.batchcreditanalisys.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommonInfo {

    @JsonProperty("existe_informacao")
    private String hasInformation;

}
