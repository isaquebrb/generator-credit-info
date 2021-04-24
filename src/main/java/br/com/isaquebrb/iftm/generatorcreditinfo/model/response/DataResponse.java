package br.com.isaquebrb.iftm.generatorcreditinfo.model.response;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.DataInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataResponse {

    @JsonProperty("content")
    private DataInfo dataInfo;

    private String date;

    private String hour;
}
