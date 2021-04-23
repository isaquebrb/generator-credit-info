package br.com.isaquebrb.iftm.batchcreditanalisys.model.response;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.data.DataInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataResponse {

    @JsonProperty("content")
    private DataInfo crednetInfoPf;

    private String date;

    private String hour;
}
