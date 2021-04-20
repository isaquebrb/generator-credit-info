package br.com.isaquebrb.iftm.batchcreditanalisys.service;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.CrednetInfoPf;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.CrednetInfoPj;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.contents.*;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.info.*;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.response.CrednetResponsePf;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.response.CrednetResponsePj;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static br.com.isaquebrb.iftm.batchcreditanalisys.utils.DateUtils.randomDate;
import static br.com.isaquebrb.iftm.batchcreditanalisys.utils.DateUtils.randomRecentDate;
import static br.com.isaquebrb.iftm.batchcreditanalisys.utils.RandomUtils.*;

@Component
public class CrednetRandomInfo {

    public CrednetResponsePf generateCrednetInfoPf(String document) {
        CrednetInfoPf crednetInfoPf = CrednetInfoPf.builder()
                .personInfo(createPersonInfo(true))
                .financialPendenciesInfo(createFinancialPendencies())
                .bacenInfo(createBacenInfo())
                .stateProtestInfo(createStateProtestInfo())
                .deathInfo(createDeathInfo())
                .scoreSerasaInfo(createScoreSerasaInfo(document))
                .presumedIncomeInfo(createPresumedIncomeInfo(document))
                .monthlyPaymentCapacityInfo(createMonthlyPaymentCapacityInfo(document))
                .creditRecovery(createCreditRecoveryInfo())
                .build();

        return new CrednetResponsePf(crednetInfoPf, LocalDate.now().toString(), LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    public CrednetResponsePj generateCrednetInfoPj(String document) {
        CrednetInfoPj crednetInfoPj = new CrednetInfoPj();
        /*CrednetInfoPf.builder()
                .financialPendenciesInfo(createFinancialPendencies())
                .personInfo(crednetPersonInfo())
                .bacenInfo(createBacenInfo())
                .stateProtestInfo(createStateProtestInfo())
                .deathInfo(createDeathInfo(document))
                .scoreSerasaInfo(createScoreSerasaInfo(document))
                .presumedIncomeInfo(createPresumedIncomeInfo(document))
                .monthlyPaymentCapacityInfo(createMonthlyPaymentCapacityInfo(document))
                .presumedBillingInfo(createPresumedBillingInfo(document))
                .creditRiskRatingInfo(createCreditRiskRatingInfo(document))
                .build();*/

        return new CrednetResponsePj(crednetInfoPj,
                LocalDate.now().toString(),
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    private CrednetPersonInfo createPersonInfo(boolean isNaturalPerson) {
        CrednetPersonContent content = CrednetPersonContent.builder()
                .name(isNaturalPerson ? "FULANO DA SILVA" : "EMBALAGENS LTDA")
                .birthDate(randomDate().toString())
                .docSituation(randomDocSituation())
                .docSituationDate(randomRecentDate().toString()).build();
        return new CrednetPersonInfo("SIM", content);
    }

    private FinancialPendenciesInfo createFinancialPendencies() {
        if (!randomBoolean()) {
            return new FinancialPendenciesInfo("SIM", new FinancialPendenciesContent(Collections.emptyList()), 0);
        }

        List<FinancialPendenciesDetail> pendenciesDetailList = new ArrayList<>();

        int randomNumber = new Random().nextInt(3);
        for (int i = 0; i < randomNumber; i++) {
            String date = randomRecentDate().toString();
            String value = randomBigDecimalValue(0d, 5000d).toString();

            Pendencies pendencies = Pendencies.builder()
                    .contract("00000000" + randomNumber)
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

            pendenciesDetailList.add(financialPendenciesDetail);
        }

        FinancialPendenciesContent content = new FinancialPendenciesContent(pendenciesDetailList);
        return new FinancialPendenciesInfo("SIM", content, 1);
    }



    public BacenInfo createBacenInfo() {
        if (!randomBoolean()) {
            return new BacenInfo("SIM", new BacenContent(null, null,
                    Collections.emptyList()), 0);
        }

        String dateOccurrence = randomDate().toString();

        List<BacenChecks> bacenChecksList = new ArrayList<>();

        int randomNumber = new Random().nextInt(3);
        for(int i = 0; i < randomNumber; i++){


            BacenChecks bacenCheck = BacenChecks.builder()
                    .date(dateOccurrence)
                    .value(randomBigDecimalValue(0d, 5000d).toString())
                    .checkNumber("00000"+randomNumber)
                    .bankNumber("00"+randomNumber)
                    .bankName("RANDOM BANK")
                    .bankAgency("0000"+randomNumber)
                    .city("Uberlândia")
                    .state("MG").build();

            bacenChecksList.add(bacenCheck);
        }

        BacenContent content = new BacenContent(dateOccurrence, dateOccurrence, bacenChecksList);

        return new BacenInfo("SIM", content, 1);
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

    public DeathInfo createDeathInfo() {
        DeathContent content;

        if (new Random().nextInt(15) > 11) {
            content = new DeathContent("OBITO");
        } else {
            content = new DeathContent("NADA CONSTA");
        }
        return new DeathInfo("SIM", content);
    }

    public ScoreSerasaInfo createScoreSerasaInfo(String document) {
        if (!isCompany(document)) {
            int score = new Random().nextInt(1000);
            int percentage = (score * 100) / 1000;

            String message = "A chance do consumidor pagar seus compromissos financeiros nos próximos 12 meses é de " + percentage + "%";

            ScoreSerasaContent content = new ScoreSerasaContent(String.valueOf(score), String.valueOf(percentage), message);
            return new ScoreSerasaInfo("SIM", content);
        } else {
            return null;
        }
    }

    public PresumedIncomeInfo createPresumedIncomeInfo(String document) {
        if (!isCompany(document)) {
            PresumedIncomeContent content = new PresumedIncomeContent(
                    randomBigDecimalValue(300d, 15000d).toString());

            return new PresumedIncomeInfo("SIM", content);
        } else {
            return null;
        }
    }

    public MonthlyPaymentCapacityInfo createMonthlyPaymentCapacityInfo(String document) {
        if (!isCompany(document)) {
            String paymentCapacity = randomBigDecimalValue(300d, 15000d).toString();
            MonthlyPaymentCapacityContent content = new MonthlyPaymentCapacityContent(paymentCapacity);
            return new MonthlyPaymentCapacityInfo("SIM", content);
        } else {
            return null;
        }
    }

    private CreditRecoveryInfo createCreditRecoveryInfo() {
        //todo finish
        return null;
    }

    public CreditRiskRatingInfo createCreditRiskRatingInfo(String document) {
        if (isCompany(document)) {
            int scorePoints = new Random().nextInt(1000);
            BigDecimal rate = randomBigDecimalValue(1d, 20d);
            String message = "PROBABILIDADE MEDIA DE INADIMPLENCIA: " + rate + "%";

            CreditRiskRatingContent content = new CreditRiskRatingContent(
                    String.valueOf(scorePoints), rate.toString(), message);
            return new CreditRiskRatingInfo("SIM", content);
        } else {
            return null;
        }
    }

    public PresumedBillingInfo createPresumedBillingInfo(String document) {
        if (isCompany(document)) {
            BigDecimal presumedBilling = randomBigDecimalValue(10000d, 100000d);
            PresumedBillingContent content = new PresumedBillingContent("", presumedBilling.toString());
            return new PresumedBillingInfo("SIM", content);
        } else {
            return null;
        }
    }
}
