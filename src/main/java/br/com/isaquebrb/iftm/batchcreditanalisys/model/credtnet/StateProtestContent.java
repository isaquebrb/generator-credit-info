package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class StateProtestContent {

    @JsonProperty("total_ocorrencia")
    private String totalOccurrence;

    @JsonProperty("data_ocorrencia_mais_antiga")
    private String lastOccurrenceDate;

    @JsonProperty("data_ocorrencia_mais_recente")
    private String recentOccurrenceDate;

    @JsonProperty("valor")
    private String value;

    @JsonProperty("protestos")
    private List<Protest> protestList;
}
