package br.com.isaquebrb.iftm.batchcreditanalisys.model.pep;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PepInfo {

    @JsonProperty("pep")
    private String pepConfirmation;

    @JsonProperty("documento")
    private String document;

    @JsonProperty("dados")
    private List<PepData> pepDataList;
}
