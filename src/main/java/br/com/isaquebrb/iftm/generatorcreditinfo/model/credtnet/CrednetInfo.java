package br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet;

import br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.info.BacenInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.info.CrednetPersonInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.info.FinancialPendenciesInfo;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.info.StateProtestInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class CrednetInfo {

    @JsonProperty("confirmei")
    protected CrednetPersonInfo personInfo;

    @JsonProperty("pendencias_financeiras")
    protected FinancialPendenciesInfo financialPendenciesInfo;

    @JsonProperty("bacen")
    protected BacenInfo bacenInfo;

    @JsonProperty("protesto_estadual")
    protected StateProtestInfo stateProtestInfo;
}
