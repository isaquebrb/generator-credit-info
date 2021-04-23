package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StateProtestContent {

    @JsonProperty("total_ocorrencia")
    private Integer totalOccurrence;

    @JsonProperty("data_ocorrencia_mais_antiga")
    private String lastOccurrenceDate;

    @JsonProperty("data_ocorrencia_mais_recente")
    private String recentOccurrenceDate;

    @JsonProperty("valor")
    private String value;

    @JsonProperty("protestos")
    private List<Protest> protestList;
}
