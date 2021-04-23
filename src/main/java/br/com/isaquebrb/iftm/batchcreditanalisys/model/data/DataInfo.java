package br.com.isaquebrb.iftm.batchcreditanalisys.model.data;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.data.info.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DataInfo {

    @JsonProperty("nome")
    private NameInfo name;

    @JsonProperty("pesquisa_enderecos")
    private AddressesSearchInfo addressSearch;

    @JsonProperty("pesquisa_telefones")
    private PhonesSearchInfo phonesSearch;

    @JsonProperty("emails")
    private EmailsInfo emails;
}
