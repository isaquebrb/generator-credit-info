package br.com.isaquebrb.iftm.batchcreditanalisys.generator;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.CrednetInfoPf;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.CrednetInfoPj;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.content.*;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.credtnet.info.*;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.enums.CreditRecoveryRange;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.response.CrednetResponsePf;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.response.CrednetResponsePj;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static br.com.isaquebrb.iftm.batchcreditanalisys.utils.DateUtils.randomDate;
import static br.com.isaquebrb.iftm.batchcreditanalisys.utils.DateUtils.randomRecentDate;
import static br.com.isaquebrb.iftm.batchcreditanalisys.utils.RandomUtils.randomBigDecimalValue;
import static br.com.isaquebrb.iftm.batchcreditanalisys.utils.RandomUtils.randomDocSituation;

@Slf4j
@Component
public class CrednetRandomInfo {

    public CrednetResponsePf generateCrednetInfoPf(String document) {
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

        return new CrednetResponsePf(crednetInfoPf, LocalDate.now().toString(), LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    public CrednetResponsePj generateCrednetInfoPj(String document) {
        log.info("[CrednetRandomInfo.generateCrednetInfoPj] Generating Crednet Info to the CNPJ " + document);
        CrednetInfoPj crednetInfoPj = CrednetInfoPj.builder()
                .financialPendenciesInfo(createFinancialPendencies())
                .personInfo(createPersonInfo(false))
                .bacenInfo(createBacenInfo())
                .stateProtestInfo(createStateProtestInfo())
                .presumedBillingInfo(createPresumedBillingInfo())
                .creditRiskRatingInfo(createCreditRiskRatingInfo()).build();

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
        if (!new Random().nextBoolean()) {
            return new FinancialPendenciesInfo("SIM", new FinancialPendenciesContent(), 0);
        }

        List<Pendencies> pendenciesList = new ArrayList<>();

        int randomNumber = new Random().nextInt(3);
        for (int i = 0; i <= randomNumber; i++) {
            String date = randomRecentDate().toString();
            String value = randomBigDecimalValue(0d, 5000d).toString();

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

        int randomNumber = new Random().nextInt(3);
        for (int i = 0; i <= randomNumber; i++) {

            BacenChecks bacenCheck = BacenChecks.builder()
                    .date(randomDate().toString())
                    .value(randomBigDecimalValue(0d, 5000d).toString())
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

        int randomNumber = new Random().nextInt(3);
        for (int i = 0; i <= randomNumber; i++) {
            String value = randomBigDecimalValue(0d, 5000d).toString();

            Protest protest = Protest.builder()
                    .date(randomDate().toString())
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
        int score = new Random().nextInt(1001);
        int percentage = (score * 100) / 1000;

        String message = "A chance do consumidor pagar seus compromissos financeiros nos próximos 12 meses é de " + percentage + "%";

        ScoreSerasaContent content = new ScoreSerasaContent(String.valueOf(score), String.valueOf(percentage), message);
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
        int randomNumber = new Random().nextInt(5);
        String creditRecoveryRange = getCreditRecoveryRange(randomNumber);
        CreditRecoveryContent content = new CreditRecoveryContent(String.valueOf(randomNumber), creditRecoveryRange);
        return new CreditRecoveryInfo("SIM", content);
    }

    private CreditRiskRatingInfo createCreditRiskRatingInfo() {
        int scorePoints = new Random().nextInt(1000);
        BigDecimal rate = randomBigDecimalValue(1d, 10d);
        String message = "PROBABILIDADE MEDIA DE INADIMPLENCIA: " + rate + "%";

        CreditRiskRatingContent content = new CreditRiskRatingContent(
                String.valueOf(scorePoints), rate.toString(), message);
        return new CreditRiskRatingInfo("SIM", content);
    }

    private PresumedBillingInfo createPresumedBillingInfo() {
        BigDecimal presumedBilling = randomBigDecimalValue(10000d, 100000d);
        PresumedBillingContent content = new PresumedBillingContent("", presumedBilling.toString());
        return new PresumedBillingInfo("SIM", content);
    }

    private String getCreditRecoveryRange(int value) {
        Map<Integer, String> creditRecoveryMap = new HashMap<>();

        creditRecoveryMap.put(0, CreditRecoveryRange.LOWEST.getLabel());
        creditRecoveryMap.put(1, CreditRecoveryRange.LOW.getLabel());
        creditRecoveryMap.put(2, CreditRecoveryRange.MEDIAN.getLabel());
        creditRecoveryMap.put(3, CreditRecoveryRange.HIGH.getLabel());
        creditRecoveryMap.put(4, CreditRecoveryRange.HIGHEST.getLabel());

        return creditRecoveryMap.get(value);
    }
}
