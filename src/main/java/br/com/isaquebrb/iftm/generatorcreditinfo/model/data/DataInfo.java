package br.com.isaquebrb.iftm.generatorcreditinfo.model.data;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.data.info.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DataInfo {

    @JsonProperty("nome")
    private NameInfo name;

    @JsonProperty("pesquisa_enderecos")
    private AddressSearchInfo addressSearch;

    @JsonProperty("pesquisa_telefones")
    private PhoneSearchInfo phonesSearch;

    @JsonProperty("emails")
    private EmailInfo emails;
}
