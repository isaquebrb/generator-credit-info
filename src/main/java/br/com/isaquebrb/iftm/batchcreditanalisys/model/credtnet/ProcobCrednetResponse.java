package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ProcobCrednetResponse {

    @JsonProperty("content")
    private CrednetInfo crednetInfo;
    private LocalDate date;
    private String hour;
}
