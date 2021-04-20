package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.info;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.contents.ScoreSerasaContent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScoreSerasaInfo extends CommonInfo {

    public ScoreSerasaInfo(String hasInfo, ScoreSerasaContent content) {
        super(hasInfo);
        this.content = content;
    }

    @JsonProperty("conteudo")
    private ScoreSerasaContent content;
}