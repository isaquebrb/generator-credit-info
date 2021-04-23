package br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FinancialPendenciesDetail {

    @JsonProperty("total_ocorrencia")
    private Integer totalOccurrences;

    @JsonProperty("data_ocorrencia_mais_antiga")
    private String lastOccurrenceDate;

    @JsonProperty("data_ocorrencia_mais_recente")
    private String recentOccurrenceDate;

    @JsonProperty("valor")
    private String value;

    @JsonProperty("tipo_anotacao")
    private String typeAnnotation;

    @JsonProperty("pendencias")
    private List<Pendencies> pendenciesList;
}
