package br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.info.*;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class CrednetInfoPf extends CrednetInfo {

    @JsonProperty("obito")
    private DeathInfo deathInfo;

    @JsonProperty("score_serasa")
    private ScoreSerasaInfo scoreSerasaInfo;

    @JsonProperty("renda_pro")
    @JsonAlias("renda_presumida")
    private PresumedIncomeInfo presumedIncomeInfo;

    @JsonProperty("capacidade_mensal_pagamento")
    private MonthlyPaymentCapacityInfo monthlyPaymentCapacityInfo;

    @JsonProperty("recuperacao_credito")
    private CreditRecoveryInfo creditRecovery;
}
