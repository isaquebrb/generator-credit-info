package br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.info.CreditRiskRatingInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.info.PresumedBillingInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class CrednetInfoPj extends CrednetInfo {

    @JsonProperty("faturamento_presumido")
    private PresumedBillingInfo presumedBillingInfo;

    @JsonProperty("classificacao_risco_credito")
    private CreditRiskRatingInfo creditRiskRatingInfo;
}
