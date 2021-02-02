package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CrednetInfo {

    @JsonProperty("confirmei")
    private CrednetPersonInfo personInfo;

    @JsonProperty("pendencias_financeiras")
    private FinancialPendenciesInfo financialPendenciesInfo;

    @JsonProperty("bacen")
    private BacenInfo bacenInfo;

    @JsonProperty("protesto_estadual")
    private StateProtestInfo stateProtestInfo;

    @JsonProperty("obito")
    private DeathInfo deathInfo;

    @JsonProperty("score_serasa")
    private ScoreSerasaInfo scoreSerasaInfo;

    @JsonProperty("renda_pro")
    @JsonAlias("renda_presumida")
    private PresumedIncomeInfo presumedIncomeInfo;

    @JsonProperty("capacidade_mensal_pagamento")
    private MonthlyPaymentCapacityInfo monthlyPaymentCapacityInfo;

    @JsonProperty("faturamento_presumido")
    private PresumedBillingInfo presumedBillingInfo;

    @JsonProperty("classificacao_risco_credito")
    private CreditRiskRatingInfo creditRiskRatingInfo;
}
