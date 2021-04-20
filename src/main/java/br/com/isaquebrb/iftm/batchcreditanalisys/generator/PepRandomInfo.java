package br.com.isaquebrb.iftm.batchcreditanalisys.generator;

import br.com.isaquebrb.iftm.batchcreditanalisys.model.pep.PepData;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.pep.PepInfo;
import br.com.isaquebrb.iftm.batchcreditanalisys.model.response.PepResponse;
import br.com.isaquebrb.iftm.batchcreditanalisys.utils.DateUtils;
import br.com.isaquebrb.iftm.batchcreditanalisys.utils.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Random;

@Slf4j
@Component
public class PepRandomInfo {

    public PepResponse generatePepInfo(String document) {
        log.info("[PepRandomInfo.generatePepInfo] Generating Pep Info to the CPF " + document);

        if (!new Random().nextBoolean()) {
            PepInfo pepInfo = new PepInfo("NAO", document, Collections.emptyList());
            return new PepResponse(pepInfo, LocalDate.now().toString(), LocalTime.now()
                    .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        }

        LocalDate dateReference = DateUtils.randomRecentDate();

        PepData pepContent = PepData.builder()
                .occupation(RandomUtils.randomOccupation())
                .agency(RandomUtils.randomAgency())
                .exerciseStartDate(dateReference.toString())
                .exerciseEndDate(dateReference.plusYears(4).toString())
                .shortageEndDate(dateReference.plusYears(8).toString()).build();

        PepInfo pepInfo = new PepInfo("SIM", document, Collections.singletonList(pepContent));

        return new PepResponse(pepInfo, LocalDate.now().toString(), LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
