package br.com.isaquebrb.iftm.generatorcreditinfo.generator;

import br.com.isaquebrb.iftm.generatorcreditinfo.exception.SystemException;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.CrednetInfoPf;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.CrednetInfoPj;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.content.*;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.credtnet.info.*;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.enums.CreditRecoveryRange;
import br.com.isaquebrb.iftm.generatorcreditinfo.model.response.CrednetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static br.com.isaquebrb.iftm.generatorcreditinfo.utils.CredtnetRandomUtils.randomDocSituation;
import static br.com.isaquebrb.iftm.generatorcreditinfo.utils.DataRandomUtils.randomCompany;
import static br.com.isaquebrb.iftm.generatorcreditinfo.utils.DataRandomUtils.randomNamePf;
import static br.com.isaquebrb.iftm.generatorcreditinfo.utils.DateRandomUtils.randomDate;
import static br.com.isaquebrb.iftm.generatorcreditinfo.utils.DateRandomUtils.timeToString;
import static br.com.isaquebrb.iftm.generatorcreditinfo.utils.NumberRandomUtils.randomBigDecimalValue;

@Slf4j
@Component
public class CrednetRandomInfo {

    public CrednetResponse generateCrednetInfoPf(String document) {
        try {
            log.info("[CrednetRandomInfo.generateCrednetInfoPf] Generating Crednet Info to the CPF " + document);

            CrednetInfoPf crednetInfoPf = CrednetInfoPf.builder()
                    .personInfo(createPersonInfo(true))
                    .financialPendenciesInfo(createFinancialPendencies())
                    .bacenInfo(createBacenInfo())
                    .stateProtestInfo(createStateProtestInfo())
                    .deathInfo(createDeathInfo())
                    .scoreSerasaInfo(createScoreSerasaInfo())
                    .presumedIncomeInfo(createPresumedIncomeInfo())
                    .monthlyPaymentCapacityInfo(createMonthlyPaymentCapacityInfo())
                    .creditRecovery(createCreditRecoveryInfo())
                    .build();

            return new CrednetResponse(crednetInfoPf, LocalDate.now().toString(), timeToString(LocalDateTime.now()));
        } catch (Exception e) {
            log.error("[CrednetRandomInfo.generateCrednetInfoPf] Error trying to generate Crednet Info", e);
            throw new SystemException(e.getMessage());
        }
    }

    public CrednetResponse generateCrednetInfoPj(String document) {
        try {
            log.info("[CrednetRandomInfo.generateCrednetInfoPj] Generating Crednet Info to the CNPJ " + document);

            CrednetInfoPj crednetInfoPj = CrednetInfoPj.builder()
                    .financialPendenciesInfo(createFinancialPendencies())
                    .personInfo(createPersonInfo(false))
                    .bacenInfo(createBacenInfo())
                    .stateProtestInfo(createStateProtestInfo())
                    .presumedBillingInfo(createPresumedBillingInfo())
                    .creditRiskRatingInfo(createCreditRiskRatingInfo()).build();

            return new CrednetResponse(crednetInfoPj,
                    LocalDate.now().toString(),
                    LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        } catch (Exception e) {
            log.error("[CrednetRandomInfo.generateCrednetInfoPj] Error trying to generate Crednet Info", e);
            throw new SystemException(e.getMessage());
        }
    }

    private CrednetPersonInfo createPersonInfo(boolean isNaturalPerson) {
        CrednetPersonContent content = CrednetPersonContent.builder()
                .name(isNaturalPerson ? randomNamePf() : randomCompany().getLabel())
                .birthDate(randomDate(1960, 2006).toString())
                .docSituation(randomDocSituation())
                .docSituationDate(randomDate(2020, 2021).toString()).build();
        return new CrednetPersonInfo("SIM", content);
    }

    private FinancialPendenciesInfo createFinancialPendencies() {
        if (!new Random().nextBoolean()) {
            return new FinancialPendenciesInfo("SIM", new FinancialPendenciesContent(), 0);
        }

        List<Pendencies> pendenciesList = new ArrayList<>();

        Integer randomNumber = new Random().nextInt(3);
        for (int i = 0; i <= randomNumber; i++) {
            String date = randomDate(2020, 2021).toString();
            String value = randomBigDecimalValue(0d, 800d).toString();

            Pendencies pendencies = Pendencies.builder()
                    .contract("00000000" + i)
                    .date(date)
                    .guarantor("NAO")
                    .value(value)
                    .origin("FINANCEIRA")
                    .modality("CREDITO E FINANCIAMENTO-FINANC")
                    .typeAnnotation("REFIN").build();

            pendenciesList.add(pendencies);
        }

        Pendencies lastPendency = pendenciesList.stream()
                .max(Comparator.comparing(p -> LocalDate.parse(p.getDate())))
                .orElseThrow(NoSuchElementException::new);

        double totalValue = pendenciesList.stream().mapToDouble(p -> Double.parseDouble(p.getValue())).sum();

        FinancialPendenciesDetail financialPendenciesDetail = FinancialPendenciesDetail.builder()
                .totalOccurrences(pendenciesList.size())
                .value(Double.toString(totalValue))
                .lastOccurrenceDate(lastPendency.getDate())
                .recentOccurrenceDate(lastPendency.getDate())
                .pendenciesList(pendenciesList)
                .typeAnnotation("REFIN").build();

        FinancialPendenciesContent content = new FinancialPendenciesContent(financialPendenciesDetail);
        return new FinancialPendenciesInfo("SIM", content, content.getFinancialPendenciesDetail().getTotalOccurrences());
    }


    private BacenInfo createBacenInfo() {
        if (!new Random().nextBoolean()) {
            return new BacenInfo("SIM", new BacenContent(), 0);
        }

        List<BacenChecks> bacenChecksList = new ArrayList<>();

        Integer randomNumber = new Random().nextInt(3);
        for (int i = 0; i <= randomNumber; i++) {

            BacenChecks bacenCheck = BacenChecks.builder()
                    .date(randomDate(2018, 2021).toString())
                    .value(randomBigDecimalValue(0d, 800d).toString())
                    .checkNumber("00000" + i)
                    .bankNumber("00" + i)
                    .bankName("RANDOM BANK")
                    .bankAgency("0000" + i)
                    .city("Uberlândia")
                    .state("MG").build();

            bacenChecksList.add(bacenCheck);
        }

        BacenChecks lastCheck = bacenChecksList.stream()
                .max(Comparator.comparing(b -> LocalDate.parse(b.getDate())))
                .orElseThrow(NoSuchElementException::new);

        BacenContent content = new BacenContent(lastCheck.getDate(), lastCheck.getDate(), bacenChecksList);

        return new BacenInfo("SIM", content, content.getBacenChecks().size());
    }

    private StateProtestInfo createStateProtestInfo() {
        if (!new Random().nextBoolean()) {
            return new StateProtestInfo("SIM", new StateProtestContent(), 0);
        }

        List<Protest> protestList = new ArrayList<>();

        Integer randomNumber = new Random().nextInt(3);
        for (int i = 0; i <= randomNumber; i++) {
            String value = randomBigDecimalValue(0d, 5000d).toString();

            Protest protest = Protest.builder()
                    .date(randomDate(2018, 2021).toString())
                    .value(value)
                    .registryOffice("UN")
                    .city("Uberlândia")
                    .state("MG")
                    .typeAnnotion("").build();

            protestList.add(protest);
        }

        Protest lastProtest = protestList.stream()
                .max(Comparator.comparing(p -> LocalDate.parse(p.getDate())))
                .orElseThrow(NoSuchElementException::new);

        double totalValue = protestList.stream().mapToDouble(p -> Double.parseDouble(p.getValue())).sum();

        StateProtestContent content = StateProtestContent.builder()
                .lastOccurrenceDate(lastProtest.getDate())
                .recentOccurrenceDate(lastProtest.getDate())
                .value(Double.toString(totalValue))
                .totalOccurrence(protestList.size())
                .protestList(protestList)
                .build();

        return new StateProtestInfo("SIM", content, content.getTotalOccurrence());
    }

    private DeathInfo createDeathInfo() {
        DeathContent content;

        if (new Random().nextInt(6) > 4) {
            content = new DeathContent("OBITO");
        } else {
            content = new DeathContent("NADA CONSTA");
        }
        return new DeathInfo("SIM", content);
    }

    private ScoreSerasaInfo createScoreSerasaInfo() {
        Integer score = new Random().nextInt(1001);
        Integer percentage = (score * 100) / 1000;

        String message = "A chance do consumidor pagar seus compromissos financeiros nos próximos 12 meses é de " + percentage + "%";

        ScoreSerasaContent content = new ScoreSerasaContent(score.toString(), percentage.toString(), message);
        return new ScoreSerasaInfo("SIM", content);
    }

    private PresumedIncomeInfo createPresumedIncomeInfo() {
        PresumedIncomeContent content = new PresumedIncomeContent(randomBigDecimalValue(300d, 15000d).toString());
        return new PresumedIncomeInfo("SIM", content);
    }

    private MonthlyPaymentCapacityInfo createMonthlyPaymentCapacityInfo() {
        String paymentCapacity = randomBigDecimalValue(300d, 15000d).toString();
        MonthlyPaymentCapacityContent content = new MonthlyPaymentCapacityContent(paymentCapacity);
        return new MonthlyPaymentCapacityInfo("SIM", content);
    }

    private CreditRecoveryInfo createCreditRecoveryInfo() {
        Integer randomNumber = new Random().nextInt(5);
        String creditRecoveryRange = getCreditRecoveryRange(randomNumber);
        CreditRecoveryContent content = new CreditRecoveryContent(randomNumber.toString(), creditRecoveryRange);
        return new CreditRecoveryInfo("SIM", content);
    }

    private CreditRiskRatingInfo createCreditRiskRatingInfo() {
        Integer scorePoints = new Random().nextInt(1000);
        BigDecimal rate = randomBigDecimalValue(1d, 10d);
        String message = "PROBABILIDADE MEDIA DE INADIMPLENCIA: " + rate + "%";

        CreditRiskRatingContent content = new CreditRiskRatingContent(
                scorePoints.toString(), rate.toString(), message);
        return new CreditRiskRatingInfo("SIM", content);
    }

    private PresumedBillingInfo createPresumedBillingInfo() {
        BigDecimal presumedBilling = randomBigDecimalValue(10000d, 100000d);
        PresumedBillingContent content = new PresumedBillingContent("", presumedBilling.toString());
        return new PresumedBillingInfo("SIM", content);
    }

    private String getCreditRecoveryRange(Integer value) {
        Map<Integer, String> creditRecoveryMap = new HashMap<>();

        creditRecoveryMap.put(0, CreditRecoveryRange.LOWEST.getLabel());
        creditRecoveryMap.put(1, CreditRecoveryRange.LOW.getLabel());
        creditRecoveryMap.put(2, CreditRecoveryRange.MEDIAN.getLabel());
        creditRecoveryMap.put(3, CreditRecoveryRange.HIGH.getLabel());
        creditRecoveryMap.put(4, CreditRecoveryRange.HIGHEST.getLabel());

        return creditRecoveryMap.get(value);
    }
}
