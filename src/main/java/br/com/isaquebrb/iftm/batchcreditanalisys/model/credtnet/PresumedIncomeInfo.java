package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PresumedIncomeInfo extends CommonInfo{

    public PresumedIncomeInfo(String hasInfo, PresumedIncomeContent content){
        super(hasInfo);
        this.content = content;
    }

    @JsonProperty("conteudo")
    private PresumedIncomeContent content;
}
