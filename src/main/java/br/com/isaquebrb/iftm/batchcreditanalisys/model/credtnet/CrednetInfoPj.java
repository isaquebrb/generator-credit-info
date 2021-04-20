package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.info.CreditRiskRatingInfo;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.info.PresumedBillingInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CrednetInfoPj extends CrednetInfo {

    @JsonProperty("faturamento_presumido")
    private PresumedBillingInfo presumedBillingInfo;

    @JsonProperty("classificacao_risco_credito")
    private CreditRiskRatingInfo creditRiskRatingInfo;
}
