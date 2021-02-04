package br.com.isaquebrb.iftm.batchcreditanalisys.service;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.*;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.response.ProcobCrednetResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

import static br.com.isaquebrb.iftm.batchcreditanalisys.utils.DateUtils.randomDate;
import static br.com.isaquebrb.iftm.batchcreditanalisys.utils.DateUtils.randomRecentDate;
import static br.com.isaquebrb.iftm.batchcreditanalisys.utils.RandomUtils.*;

@Component
public class ProcobGenerateRandomInfo {

    public ProcobCrednetResponse generateCrednetInfo(String document) {
        CrednetInfo crednetInfo = CrednetInfo.builder()
                .financialPendenciesInfo(createFinancialPendencies())
                .personInfo(crednetPersonInfo())
                .bacenInfo(createBacenInfo())
                .stateProtestInfo(createStateProtestInfo())
                .deathInfo(createDeathInfo(document))
                .scoreSerasaInfo(createScoreSerasaInfo(document))
                .presumedIncomeInfo(createPresumedIncomeInfo(document))
                .monthlyPaymentCapacityInfo(createMontlyPaymentCapacityInfo(document))
                .presumedBillingInfo(createPresumedBillingInfo(document))
                .creditRiskRatingInfo(createCreditRiskRatingInfo(document))
                .build();

        return new ProcobCrednetResponse(crednetInfo,
                LocalDate.now().toString(),
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    public FinancialPendenciesInfo createFinancialPendencies() {
        if (randomBoolean()) {
            String date = randomRecentDate().toString();
            String value = randomBigDecimalValue(0d, 5000d).toString();

            Pendencies pendencies = Pendencies.builder()
                    .contract("999999999999999")
                    .date(date)
                    .guarantor("NAO")
                    .value(value)
                    .origin("FINANCEIRA")
                    .modality("CREDITO E FINANCIAMENTO-FINANC")
                    .typeAnnotation("REFIN")
                    .build();

            FinancialPendenciesDetail financialPendenciesDetail = FinancialPendenciesDetail.builder()
                    .totalOccurrences(1)
                    .value(value)
                    .lastOccurrenceDate(date)
                    .recentOccurrenceDate(date)
                    .pendenciesList(Collections.singletonList(pendencies))
                    .typeAnnotation("REFIN").build();

            FinancialPendenciesContent content = FinancialPendenciesContent.builder()
                    .detailList(Collections.singletonList(financialPendenciesDetail)).build();

            return new FinancialPendenciesInfo("SIM", content, 1);
        } else {
            return new FinancialPendenciesInfo("SIM", new FinancialPendenciesContent(), 0);
        }
    }

    public CrednetPersonInfo crednetPersonInfo() {
        return new CrednetPersonInfo("SIM",
                CrednetPersonContent.builder()
                        .name("FULANO DA SILVA")
                        .birthDate(randomDate().toString())
                        .docSituation(randomDocSituation())
                        .docSituationDate(randomRecentDate().toString()).build());
    }

    public BacenInfo createBacenInfo() {
        if (randomBoolean()) {
            String dateOccurrence = randomDate().toString();

            BacenChecks bacenCheck = BacenChecks.builder()
                    .date(dateOccurrence)
                    .value(randomBigDecimalValue(0d, 5000d).toString())
                    .checkNumber("999999")
                    .bankNumber("999")
                    .bankName("RANDOM BANK")
                    .bankAgency("99999")
                    .city("Uberlândia")
                    .state("MG").build();

            BacenContent content = new BacenContent(dateOccurrence, dateOccurrence,
                    Collections.singletonList(bacenCheck));

            return new BacenInfo("SIM", content, 1);
        } else {
            return new BacenInfo("SIM", new BacenContent(), 0);
        }
    }

    public StateProtestInfo createStateProtestInfo() {
        if (randomBoolean()) {
            String dateOccurrence = randomDate().toString();
            String value = randomBigDecimalValue(0d, 5000d).toString();

            Protest protest = Protest.builder()
                    .date(dateOccurrence)
                    .value(value)
                    .registryOffice("UN")
                    .city("Uberlândia")
                    .state("MG")
                    .typeAnnotion("").build();

            StateProtestContent content = StateProtestContent.builder()
                    .lastOccurrenceDate(dateOccurrence)
                    .recentOccurrenceDate(dateOccurrence)
                    .value(value)
                    .totalOccurrence(1)
                    .protestList(Collections.singletonList(protest))
                    .build();

            return new StateProtestInfo("SIM", content, 1);
        } else {
            return new StateProtestInfo("SIM", new StateProtestContent(), 0);
        }
    }

    public DeathInfo createDeathInfo(String document) {
        if (!isCompany(document)) {
            DeathContent content;

            //random death %
            if (randomDouble(0d, 15d) > 11) {
                content = new DeathContent("OBITO");
                return new DeathInfo("SIM", content);
            }
            content = new DeathContent("NADA CONSTA");
            return new DeathInfo("SIM", content);
        } else {
            return null;
        }
    }

    public ScoreSerasaInfo createScoreSerasaInfo(String document) {
        //pf
        return new ScoreSerasaInfo();
    }

    public PresumedIncomeInfo createPresumedIncomeInfo(String document) {
        //pf
        return new PresumedIncomeInfo();
    }

    public MonthlyPaymentCapacityInfo createMontlyPaymentCapacityInfo(String document) {
        //pf
        return new MonthlyPaymentCapacityInfo();
    }

    public CreditRiskRatingInfo createCreditRiskRatingInfo(String document) {
        //pj
        return new CreditRiskRatingInfo();
    }

    public PresumedBillingInfo createPresumedBillingInfo(String document) {
        //pj
        return new PresumedBillingInfo();
    }
}
